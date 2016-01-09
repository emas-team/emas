/**
 * 
 */
package emas.operators.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import emas.operators.impl.simple.evaluation.Evaluation;
import emas.operators.impl.simple.intersection.Intersection;
import emas.operators.impl.simple.mutation.Mutation;

/**
 * Test class for GenotypeOperationFactory.
 * 
 * @author Klaudia Balazy, Robert Poparda
 */
public class GenotypeOperationFactoryTest {
    private static final String MESSAGE = "Unexpexted class returned.";

    /**
     * Test method for
     * {@link emas.operators.impl.GenotypeOperationFactory#createMutationOp()}.
     */
    @Test
    public void testCreateMutationOp() {
        assertEquals(MESSAGE, Mutation.class, new GenotypeOperationFactory()
                .createMutationOp().getClass());
    }

    /**
     * Test method for
     * {@link emas.operators.impl.GenotypeOperationFactory#createIntersectionOp()}
     * .
     */
    @Test
    public void testCreateIntersectionOp() {
        assertEquals(MESSAGE, Intersection.class,
                new GenotypeOperationFactory().createIntersectionOp()
                        .getClass());
    }

    /**
     * Test method for
     * {@link emas.operators.impl.GenotypeOperationFactory#createEvaluationOp()}
     * .
     */
    @Test
    public void testCreateEvaluationOp() {
        assertEquals(MESSAGE, Evaluation.class, new GenotypeOperationFactory()
                .createEvaluationOp().getClass());
    }

}
