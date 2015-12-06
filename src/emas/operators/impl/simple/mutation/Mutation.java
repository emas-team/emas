package emas.operators.impl.simple.mutation;

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

	IEvaluation<IGenotype> evaluation;

	/**
	 * Default constructor. Sets the default evaluation method.
	 */
	public Mutation() {
		this(new Evaluation());
	}

	/**
	 * Constructor.
	 */
	public Mutation(IEvaluation<IGenotype> evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public void mutate(IGenotype genotype) {
		// do mutation
	}

}
