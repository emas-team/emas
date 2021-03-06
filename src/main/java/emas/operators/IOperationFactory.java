package emas.operators;

import emas.agents.IGenotype;

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

    public IMutation<IGenotype> createMutationOp();

    /**
     * Creates and returns new object providing implementation of intersection
     * operation.
     * 
     * @return implementation of intersection operation.
     */
    public IIntersection<IGenotype> createIntersectionOp();

    /**
     * Creates and returns new object providing implementation of evaluation
     * operation.
     * 
     * @return implementation of evaluation operation.
     */
    public IEvaluation<IGenotype> createEvaluationOp();
}
