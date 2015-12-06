package emas.operators;

import emas.agents.Genotype;
import emas.agents.IGenotype;

/**
 * Mutation operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IMutation <X extends IGenotype> {

	/**
	 * Takes genotype parameters and modifies it.
	 * 
	 * @param genotype
	 *            genotype to be mutates
	 */
	public void mutate(X genotype);
}
