package emas.operators.impl.simple.mutation;

import java.util.LinkedList;
import java.util.List;

import emas.agents.IGenotype;
import emas.operators.IMutation;

/**
 * Implementation of mutation operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Mutation implements IMutation<IGenotype> {

    private List<Double> mutatedList = new LinkedList<Double>();

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void mutate(IGenotype genotype) {
        if (genotype == null) {
            throw new IllegalArgumentException("Genotype cannot be null.");
        }

        List<Double> list = genotype.getGenes();
        list.forEach(value -> getMutatedList().add(
                new Double(value + (Math.random() - 0.5) * value)));

        updateGenotype(genotype);
    }

    @SuppressWarnings("unchecked")
    private void updateGenotype(IGenotype genotype) {
        // if the mutated list is worse then the original one, it can
        // be returned - now mutated list is always returned

        if (genotype == null) {
            throw new IllegalArgumentException();
        }

        synchronized (genotype) {
            genotype.getGenes().clear();
            genotype.getGenes().addAll(getMutatedList());
        }
    }

    private List<Double> getMutatedList() {
        return mutatedList;
    }

}
