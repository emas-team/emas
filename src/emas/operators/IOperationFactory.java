package emas.operators;

/**
 * Operation factory interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IOperationFactory {

	/**
	 * Creates and returns new object providing implementation of mutation
	 * operation.
	 * 
	 * @return implementation of mutation operation.
	 */
	public IMutation createMutationOp();

	/**
	 * Creates and returns new object providing implementation of selection
	 * operation.
	 * 
	 * @return implementation of selection operation.
	 */
	public ISelection createSelectionOp();

	/**
	 * Creates and returns new object providing implementation of intersection
	 * operation.
	 * 
	 * @return implementation of intersection operation.
	 */
	public IIntersection createIntersectionOp();

	/**
	 * Creates and returns new object providing implementation of evaluation
	 * operation.
	 * 
	 * @return implementation of evaluation operation.
	 */
	public IEvaluation createEvaluationOp();
}
