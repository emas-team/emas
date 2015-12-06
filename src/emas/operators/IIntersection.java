package emas.operators;

import emas.agents.Genotype;
import emas.agents.IGenotype;

/**
 * Intersection operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IIntersection <X extends IGenotype> {

	/**
	 * Does intersection for provided pair of genotype and returns newly created
	 * genotype.
	 * 
	 * @param genotype1
	 *            first genotype
	 * @param genotype2
	 *            second genotype
	 * @return newly created genotype
	 */
	public Genotype doIntersection(X genotype1, X genotype2);
}
