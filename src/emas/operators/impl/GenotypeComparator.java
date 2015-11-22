package emas.operators.impl;

import java.util.Comparator;

import emas.agents.Genotype;
import emas.operators.IEvaluation;

/**
 * Genotype comparator. Provides implementation for comparing genotypes.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class GenotypeComparator implements Comparator<Genotype> {

	private IEvaluation qualityEvaluator;

	/**
	 * Constructor.
	 * 
	 * @param evaluator
	 *            evalutor that will be used to estimate genotypes quality
	 */
	public GenotypeComparator(IEvaluation evaluator) {
		this.qualityEvaluator = evaluator;
	}

	@Override
	public int compare(Genotype genotype1, Genotype genotype2) {

		return (int) Math.signum(getQualityEvaluator().evaluateQuality(
				genotype1)
				- getQualityEvaluator().evaluateQuality(genotype2));
	}

	public IEvaluation getQualityEvaluator() {
		return qualityEvaluator;
	}

	public void setQualityEvaluator(IEvaluation qualityEvaluator) {
		this.qualityEvaluator = qualityEvaluator;
	}

}
