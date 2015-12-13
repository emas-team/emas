package emas.operators.impl.simple.mutation;

import static org.junit.Assert.*;
import static emas.operators.impl.RandomGenotypeGenerator.createRandomGenotype;

import org.junit.Test;

import emas.agents.genotype.Genotype;

/**
 * Test class for Mutation operation.
 * 
 * @author Klaudia Balazy, Robert Poparda
 */
public class MutationTest {

	@Test
	public void testMutate() {
		int genotypeLength = 10;
		Genotype genotype = createRandomGenotype(genotypeLength);
		new Mutation().mutate(genotype);

		assertFalse("Mutation cleared genotype list.", genotype.getList()
				.isEmpty());
		assertEquals("Mutated genotype has improper length.", genotype
				.getList().size(), genotypeLength);
	}

}
