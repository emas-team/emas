package emas.operators;

import emas.agents.Genotype;

/**
 * Mutation operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IMutation {

	/**
	 * Takes genotype parameters and modifies it.
	 * 
	 * @param genotype
	 *            genotype to be mutates
	 */
	public void mutate(Genotype genotype);
}
