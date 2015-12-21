package emas.operators.impl.simple.mutation;

import java.util.LinkedList;
import java.util.List;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;
import emas.operators.IMutation;
import emas.operators.impl.simple.evaluation.Evaluation;

/**
 * Implementation of mutation operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Mutation implements IMutation<IGenotype> {

	// private IEvaluation<IGenotype> evaluation;
	private List<Double> mutatedList = new LinkedList<Double>();

	/**
	 * Default constructor. Sets the default evaluation method.
	 */
	public Mutation() {
		this(new Evaluation());
	}

	/**
	 * Constructor.
	 * 
	 * @param evaluation
	 *            evaluation
	 */
	public Mutation(IEvaluation<IGenotype> evaluation) {
		// this.evaluation = evaluation;
	}

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

	private void updateGenotype(IGenotype genotype) {
		// TODO if the mutated list is worse then the original one, it can
		// be returned - now mutated list is always returned

		synchronized (genotype) {
			genotype.getGenes().clear();
			genotype.getGenes().addAll(getMutatedList());
		}
	}

	private List<Double> getMutatedList() {
		return mutatedList;
	}

}
