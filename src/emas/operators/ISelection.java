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
	 * @param genotypes
	 *            list of genotype
	 */
	public Genotype getWorst(List<Genotype> genotypes);

	/**
	 * Removes given number of worst genotypes.
	 * 
	 * @param agents
	 *            list of genotypes
	 * @param amount
	 *            amount of genotypes to remove
	 */
	public List<Genotype> getWorst(List<Genotype> genotypes, int amount);

}
