package emas.operators;

import emas.agents.IGenotype;

/**
 * Mutation operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IMutation<T extends IGenotype> {

    /**
     * Takes genotype parameters and modifies it.
     * 
     * @param genotype
     *            genotype to be mutates
     */
    public void mutate(T genotype);
}
