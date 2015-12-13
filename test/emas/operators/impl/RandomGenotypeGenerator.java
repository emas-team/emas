package emas.operators.impl;

import emas.agents.genotype.Genotype;

public class RandomGenotypeGenerator {
	public static Genotype createRandomGenotype(int listSize) {
		Genotype genotype = new Genotype();
		for (int i = 0; i < listSize; i++) {
			genotype.getList().add((Math.random() - 0.5) * 10.0);
		}
		return genotype;
	}
}
