package emas.operators;

import emas.agents.IGenotype;

/**
 * Evaluation operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IEvaluation<T extends IGenotype> {

	/**
	 * Evaluates quality of a genotype. The lower value is returned the better
	 * genotype was evaluated.
	 * 
	 * @param genotype
	 *            genotype to be evaluated
	 * @return result of evaluation
	 */
	public double evaluateQuality(T genotype);
}
