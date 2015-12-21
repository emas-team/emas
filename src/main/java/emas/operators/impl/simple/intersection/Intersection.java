package emas.operators.impl.simple.intersection;

import java.util.Iterator;
import java.util.List;

import emas.agents.IGenotype;
import emas.agents.genotype.Genotype;
import emas.operators.IEvaluation;
import emas.operators.IIntersection;
import emas.operators.impl.simple.evaluation.Evaluation;

/**
 * Implementation of intersection operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Intersection implements IIntersection<IGenotype> {

	private IEvaluation<IGenotype> evaluation;

	/**
	 * Default constructor. Sets evaluation as {@link Evaluation}
	 */
	public Intersection() {
		this(new Evaluation());
	}

	/**
	 * Constructor.
	 * 
	 * @param evaluation
	 */
	public Intersection(IEvaluation<IGenotype> evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public IGenotype doIntersection(IGenotype genotype1, IGenotype genotype2) {

		assertParametersCorrect(genotype1, genotype2);

		double val1 = evaluation.evaluateQuality(genotype1);
		double val2 = evaluation.evaluateQuality(genotype2);

		Genotype child = new Genotype();
		child.getGenes().clear();

		int dimensions = genotype1.getGenes().size();
		double sign = Math.signum(val1 - val2);
		for (int i = 0; i < dimensions; i++) {
			double x1 = (Double) genotype1.getGenes().get(i);
			double x2 = (Double) genotype2.getGenes().get(i);
			double betterX = (val1 > val2) ? x2 : x1;
			double x = betterX + sign * (x2 - x1);
			child.getGenes().add(x);
		}

		return child;
	}

	private void assertParametersCorrect(IGenotype genotype1,
			IGenotype genotype2) {
		if (genotype1 == null || genotype2 == null) {
			throw new IllegalArgumentException("Genotype cannot be null.");
		}

		List genes1 = genotype1.getGenes();
		List genes2 = genotype1.getGenes();

		if (genes1 == null || genes2 == null || genes1.isEmpty()
				|| genes2.isEmpty()) {
			throw new IllegalArgumentException("Genotype list cannot be empty.");
		}

		if (genes1.size() != genes2.size()) {
			throw new IllegalArgumentException("Genotypes has unequal length.");
		}
	}

	/**
	 * Warning! Returnes avarege values.
	 * 
	 * @param genotype1
	 *            genotype 1
	 * @param genotype2
	 *            genotype 2
	 * @return child genotype
	 */
	private IGenotype alternativeCrossover(IGenotype genotype1,
			IGenotype genotype2) {
		List<Double> genes1 = genotype1.getGenes();
		List<Double> genes2 = genotype1.getGenes();

		IGenotype childGenotype = new Genotype();
		@SuppressWarnings("unchecked")
		List<Double> genes = childGenotype.getGenes();

		Iterator<Double> it1 = genes1.iterator();
		Iterator<Double> it2 = genes2.iterator();

		while (it1.hasNext() && it2.hasNext()) {
			genes.add(intersect(it1.next(), it2.next()));
		}

		return childGenotype;
	}

	private Double intersect(Double gen1, Double gen2) {
		long bits1 = Double.doubleToLongBits(gen1);
		long bits2 = Double.doubleToLongBits(gen2);
		long child = 0;

		for (int i = 0; i < 64; i++) {
			long bit1 = bits1 >> i & 0x01;
			long bit2 = bits2 >> i & 0x01;
			child = child | (((Math.random() < 0.5) ? bit1 : bit2) << i);
		}
		return Double.longBitsToDouble(child);
	}

	private void showAsBits(long value) {
		long tmp = value;
		for (int i = 0; i < 64; i++) {
			long bit = tmp >> i & 0x01;
			System.out.print(bit);
		}
		System.out.println();
	}
}
