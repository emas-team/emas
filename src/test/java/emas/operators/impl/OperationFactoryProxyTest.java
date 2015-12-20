package emas.operators.impl;

import static org.junit.Assert.*;

import emas.agents.IGenotype;
import emas.agents.genotype.Genotype;
import emas.operators.IEvaluation;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.impl.simple.evaluation.Evaluation;
import emas.operators.impl.simple.intersection.Intersection;
import emas.operators.impl.simple.mutation.Mutation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 * Test class for OperationFactoryProxy.
 * 
 * @author Klaudia Balazy, Robert Poparda
 */
public class OperationFactoryProxyTest {

	@Rule
	private final ExpectedException exception = ExpectedException.none();
	private static final String BAD_OP_MSG = "Bad operation object returned.";

	/**
	 * Asserts if no exceptions are thrown.
	 */
	@Test
	public void testCreateMutationOp() {
		// given
		GenotypeOperationFactory gof = Mockito
				.mock(GenotypeOperationFactory.class);
		OperationFactoryProxy ofp = getOperationFactoryProxy();
		ofp.setService(gof);
		IMutation<IGenotype> operation = Mockito.mock(Mutation.class);
		Mockito.when(ofp.createMutationOp()).thenReturn(operation);

		// when
		IMutation<IGenotype> result = ofp.createMutationOp();

		// then
		assertEquals(BAD_OP_MSG, operation, result);
	}

	@Test
	public void testCreateIntersectionOp() {
		// given
		GenotypeOperationFactory gof = Mockito
				.mock(GenotypeOperationFactory.class);
		OperationFactoryProxy ofp = getOperationFactoryProxy();
		ofp.setService(gof);
		IIntersection<IGenotype> operation = Mockito.mock(Intersection.class);
		Mockito.when(ofp.createIntersectionOp()).thenReturn(operation);

		// when
		IIntersection<IGenotype> result = ofp.createIntersectionOp();

		// then
		assertEquals(BAD_OP_MSG, operation, result);
	}

	@Test
	public void testCreateEvaluationOp() {
		// given
		GenotypeOperationFactory gof = Mockito
				.mock(GenotypeOperationFactory.class);
		OperationFactoryProxy ofp = getOperationFactoryProxy();
		ofp.setService(gof);
		IEvaluation<IGenotype> operation = Mockito.mock(Evaluation.class);
		Mockito.when(ofp.createEvaluationOp()).thenReturn(operation);

		// when
		IEvaluation<IGenotype> result = ofp.createEvaluationOp();

		// then
		assertEquals(BAD_OP_MSG, operation, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void initializationWhenNoGenotypeSpecifedTest() {
		try {
			new OperationFactoryProxy() {
				@Override
				protected Class<IGenotype> retrieveGenotypeClassFromXML() {
					return null;
				}
			};
		} catch (Exception e) {
			assertEquals("Unexpected error message of exception.",
					"Type is not specified.", e.getMessage());
			throw e;
		}
	}

	/**
	 * Asserts if no errors are thrown when known class is set as type of
	 * genotype. See rules above.
	 */
	@Test
	public void initializationWhenGenotypeSpecifedTest() {
		OperationFactoryProxy ofp = getOperationFactoryProxy();
		assertEquals("Improper class of genotype saved.", ofp.getType(),
				Genotype.class);
		assertEquals("Improper servie initilized.",
				ofp.getService().getClass(), GenotypeOperationFactory.class);
	}

	private OperationFactoryProxy getOperationFactoryProxy() {
		return new OperationFactoryProxy() {
			@Override
			protected Class<? extends IGenotype> retrieveGenotypeClassFromXML() {
				return Genotype.class;
			}
		};
	}

}
