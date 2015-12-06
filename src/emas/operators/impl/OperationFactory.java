package emas.operators.impl;

import emas.operators.IEvaluation;
import emas.agents.IGenotype;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.IOperationFactory;
import emas.operators.impl.evaluation.Evaluation;
import emas.operators.impl.intersection.Intersection;
import emas.operators.impl.mutation.Mutation;

/**
 * Operation factory implementation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class OperationFactory implements IOperationFactory {

	public IEvaluation internalEvaluation;
	
	private Class<IGenotype> type;

	public OperationFactory(Class<IGenotype> type) {
		this(new Evaluation(),type);
		
	}
	/**
	 * Constructor.
	 * 
	 * @param evaluation
	 *            evaluation method that should be used by other methods
	 */
	public OperationFactory(IEvaluation evaluation, Class<IGenotype> type) {
		this.internalEvaluation = evaluation;
		this.setType(type);
	}
	
	public Class<IGenotype> getType() {
		return type;
	}

	public void setType(Class<IGenotype> type) {
		this.type = type;
	}
	
	@Override
	public IMutation createMutationOp() {
		return new Mutation(internalEvaluation);
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
