package emas.operators.impl.simple.evaluation;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import emas.agents.genotype.Genotype;
import emas.operators.impl.utils.ParametersHolder;

/**
 * Test class for Evaluation operation.
 * 
 * @author Klaudia Balazy, Robert Poparda
 */
public class EvaluationTest {

	private Double storedA = null;

	@Before
	public void prepareTest() {
		storedA = null;
		try {
			storedA = ParametersHolder.getA();
		} catch (NullPointerException e) {
			Logger.getLogger(this.getClass().getCanonicalName()).log(
					Level.WARNING, "No value was saved in ParametersHolder.");
		}
		ParametersHolder.setA(1.0);
	}

	@Test
	public void testEvaluateQuality() {
		Genotype genotype = new Genotype();

		genotype.getList().clear();

		genotype.getList().add(1.0);
		genotype.getList().add(2.0);
		genotype.getList().add(3.0);

		Evaluation evaluation = new Evaluation();

		assertEquals("Unexpected result of evaluation", 14.0,
				evaluation.evaluateQuality(genotype), 0.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEvaluateQualityWhithEmptyList() {
		Genotype genotype = new Genotype();
		genotype.getList().clear();

		Evaluation evaluation = new Evaluation();
		evaluation.evaluateQuality(genotype);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEvaluateQualityWithBadObjects() {
		Genotype genotype = new Genotype();
		genotype.getList().add("Bad object");
		Evaluation evaluation = new Evaluation();
		evaluation.evaluateQuality(genotype);
	}

	@After
	public void tearDown() {
		ParametersHolder.setA(storedA);
	}

}
