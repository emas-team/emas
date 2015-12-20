package emas.operators.impl;

import emas.operators.IEvaluation;
import emas.agents.IGenotype;
import emas.agents.genotype.Genotype;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.IOperationFactory;
import emas.operators.impl.utils.ParametersHolder;

/**
 * Operation factory implementation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class OperationFactoryProxy implements IOperationFactory {

	private IOperationFactory service;
	private Class<? extends IGenotype> type;

	/**
	 * Constructor.
	 */
	public OperationFactoryProxy() {
		type = getType();
		if (Genotype.class.equals(getType())) {
			setService(new GenotypeOperationFactory());
		} else {
			String message = getType() == null ? "Type is not specified."
					: "This implementation: " + getType().getCanonicalName()
							+ " is not supported.";
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMutation<IGenotype> createMutationOp() {
		return getService().createMutationOp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IIntersection<IGenotype> createIntersectionOp() {
		return getService().createIntersectionOp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEvaluation<IGenotype> createEvaluationOp() {
		return getService().createEvaluationOp();
	}

	/**
	 * Retrieves class from xml file. Scope 'protected' to be accessed and
	 * overriden in tests.
	 * 
	 * @return class of genotype
	 */
	protected Class<? extends IGenotype> retrieveGenotypeClassFromXML() {
		return ParametersHolder.getGenotypeClass();

	}

	/**
	 * Type getter.
	 * 
	 * @return
	 */
	protected Class<? extends IGenotype> getType() {
		if (type == null) {
			type = retrieveGenotypeClassFromXML();
		}
		return type;
	}

	/**
	 * Getter. For tests use.
	 * 
	 * @return current service
	 */
	protected IOperationFactory getService() {
		return service;
	}

	protected void setService(IOperationFactory service) {
		this.service = service;
	}

}
