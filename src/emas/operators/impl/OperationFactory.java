package emas.operators.impl;

import emas.operators.IEvaluation;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.IOperationFactory;
import emas.operators.ISelection;
import emas.operators.impl.evaluation.Evaluation;
import emas.operators.impl.intersection.Intersection;
import emas.operators.impl.mutation.Mutation;
import emas.operators.impl.selection.Selection;

/**
 * Operation factory implementation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class OperationFactory implements IOperationFactory {

	public IEvaluation internalEvaluation;

	public OperationFactory() {
		this(new Evaluation());
	}

	/**
	 * Constructor.
	 * 
	 * @param evaluation
	 *            evaluation method that should be used by other methods
	 */
	public OperationFactory(IEvaluation evaluation) {
		this.internalEvaluation = evaluation;
	}

	@Override
	public IMutation createMutationOp() {
		return new Mutation(internalEvaluation);
	}

	@Override
	public ISelection createSelectionOp() {
		return new Selection(internalEvaluation);
	}

	@Override
	public IIntersection createIntersectionOp() {
		return new Intersection(internalEvaluation);
	}

	@Override
	public IEvaluation createEvaluationOp() {
		return new Evaluation();
	}

}
