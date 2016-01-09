package emas.operators.impl.utils;

import java.util.Comparator;

import emas.agents.genotype.Genotype;
import emas.operators.IEvaluation;

/**
 * Genotype comparator. Provides implementation for comparing genotypes.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class GenotypeComparator implements Comparator<Genotype> {

	private IEvaluation<Genotype> qualityEvaluator;

	/**
	 * Constructor.
	 * 
	 * @param evaluator
	 *            evaluator that will be used to estimate genotypes quality
	 */
	public GenotypeComparator(IEvaluation<Genotype> evaluator) {
		this.qualityEvaluator = evaluator;
	}

	@Override
	public int compare(Genotype genotype1, Genotype genotype2) {

		return (int) (Math.signum(getQualityEvaluator().evaluateQuality(
				genotype2)
				- getQualityEvaluator().evaluateQuality(genotype1)));
	}

	public IEvaluation<Genotype> getQualityEvaluator() {
		return qualityEvaluator;
	}

	public void setQualityEvaluator(IEvaluation<Genotype> qualityEvaluator) {
		this.qualityEvaluator = qualityEvaluator;
	}

}
