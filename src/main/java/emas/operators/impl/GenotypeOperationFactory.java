package emas.operators.impl;

import emas.operators.IEvaluation;
import emas.agents.IGenotype;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.IOperationFactory;
import emas.operators.impl.simple.evaluation.Evaluation;
import emas.operators.impl.simple.intersection.Intersection;
import emas.operators.impl.simple.mutation.Mutation;

/**
 * Operation factory implementation for Genotype.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class GenotypeOperationFactory implements IOperationFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMutation<IGenotype> createMutationOp() {
		return new Mutation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IIntersection<IGenotype> createIntersectionOp() {
		return new Intersection();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEvaluation<IGenotype> createEvaluationOp() {
		return new Evaluation();
	}

}
