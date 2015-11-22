package emas.operators;

import emas.agents.Genotype;

/**
 * Intersection operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IIntersection {

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
	public Genotype doIntersection(Genotype genotype1, Genotype genotype2);
}
