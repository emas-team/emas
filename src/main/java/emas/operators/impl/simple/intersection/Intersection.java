package emas.operators.impl.simple.intersection;

import java.util.Iterator;
import java.util.List;

import emas.agents.IGenotype;
import emas.agents.genotype.Genotype;
import emas.operators.IIntersection;

/**
 * Implementation of intersection operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Intersection implements IIntersection<IGenotype> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IGenotype doIntersection(IGenotype genotype1, IGenotype genotype2) {
		if (genotype1 == null || genotype2 == null) {
			throw new IllegalArgumentException("Genotype cannot be null.");
		}

		List<Double> list1 = genotype1.getGenes();
		List<Double> list2 = genotype1.getGenes();

		if (list1 == null || list2 == null || list1.size() == 0
				|| list2.size() == 0) {
			throw new IllegalArgumentException("Genotype list cannot be empty.");
		}
		if (list1.size() != list2.size()) {
			throw new IllegalArgumentException("Genotypes has unequal length.");
		}

		IGenotype childGenotype = new Genotype();
		childGenotype.getGenes().clear();
		List<Double> genes = childGenotype.getGenes();

		Iterator<Double> it1 = list1.iterator();
		Iterator<Double> it2 = list2.iterator();

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
