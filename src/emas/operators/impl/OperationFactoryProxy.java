package emas.operators.impl;

import emas.operators.IEvaluation;
import emas.agents.Genotype;
import emas.agents.IGenotype;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.IOperationFactory;

/**
 * Operation factory implementation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class OperationFactoryProxy implements IOperationFactory {

	private IOperationFactory service;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *            type of method that is
	 */
	public OperationFactoryProxy(Class<IGenotype> type) {
		if (Genotype.class.equals(type)) {
			service = new GenotypeOperationFactory();
		} else {
			String message = type == null ? "Type is not specified."
					: "This implementation: " + type.getCanonicalName()
							+ " is not supported.";
			throw new IllegalArgumentException(message);
		}
	}

	@Override
	public IMutation<IGenotype> createMutationOp() {
		return service.createMutationOp();
	}

	@Override
	public IIntersection<IGenotype> createIntersectionOp() {
		return service.createIntersectionOp();
	}

	@Override
	public IEvaluation<IGenotype> createEvaluationOp() {
		return service.createEvaluationOp();
	}

}
