package emas.operators.impl.simple.intersection;

import static org.junit.Assert.*;
import static emas.operators.impl.RandomGenotypeGenerator.createRandomGenotype;

import org.junit.Test;

import emas.agents.genotype.Genotype;

/**
 * Test class for Intersection operation.
 * 
 * @author Klaudia Balazy, Robert Poparda
 */
public class IntersectionTest {

	@Test
	public void testDoIntersection() {
		int genotypeLength = 10;
		Genotype genotype1 = createRandomGenotype(genotypeLength);
		Genotype genotype2 = createRandomGenotype(genotypeLength);
		Genotype child = (Genotype) new Intersection().doIntersection(
				genotype1, genotype2);

		assertNotNull("Intersection returned null genotype.", child);
		assertEquals("Child genotype has improper length.", child.getList()
				.size(), genotypeLength);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDoIntersectionWhenSecondGenotypeNull() {
		int genotypeLength = 10;
		Genotype genotype = createRandomGenotype(genotypeLength);
		new Intersection().doIntersection(genotype, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoIntersectionWhenFirstGenotypeNull() {
		int genotypeLength = 10;
		Genotype genotype = createRandomGenotype(genotypeLength);
		new Intersection().doIntersection(null, genotype);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoIntersectionWhenGenotypesNull() {
		new Intersection().doIntersection(null, null);
	}

}
