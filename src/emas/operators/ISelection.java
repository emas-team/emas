package emas.operators;

import java.util.List;

import emas.agents.Genotype;

/**
 * Selection operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface ISelection {

	/**
	 * Removes worst genotype.
	 * 
	 * @param agents
	 *            list of genotype
	 */
	public void removeWorst(List<Genotype> agents);

	/**
	 * Removes given number of worst genotypes.
	 * 
	 * @param agents
	 *            list of genotypes
	 * @param amount
	 *            amount of genotypes to remove
	 */
	public void removeWorst(List<Genotype> agents, int amount);

}
