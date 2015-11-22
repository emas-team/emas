package emas.operators.impl.mutation;

import emas.agents.Agent;
import emas.operators.IEvaluation;
import emas.operators.IMutation;
import emas.operators.impl.evaluation.Evaluation;

/**
 * Implementation of mutation operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Mutation implements IMutation {

	IEvaluation evaluation;

	/**
	 * Default constructor. Sets the default evaluation method.
	 */
	public Mutation() {
		this(new Evaluation());
	}

	/**
	 * Constructor.
	 */
	public Mutation(IEvaluation evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public void mutate(Agent agent) {
		// do mutation
	}

}
