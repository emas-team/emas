package emas.operators;

import emas.agents.IGenotype;

/**
 * Intersection operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IIntersection<T extends IGenotype> {

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
    public T doIntersection(T genotype1, T genotype2);
}
