package emas.agents.genotype;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;
import emas.operators.impl.GenotypeOperationFactory;

public class Genotype implements IGenotype {

	private List<Double> genes;
	private Double fitness = null;

	public Genotype() {
		genes = new LinkedList<>();
		Random random = new Random();
		for (int i = 0; i < 2; i++) {
			// TODO paramtetrize range
			Double d = random.nextDouble() * 1000;
			genes.add(d);
		}
	}

	public Genotype(List<Double> genes) {
		this.genes = genes;
	}

	@Override
	public Double evaluate() {
		if (fitness == null) {
			IEvaluation evaluation = (new GenotypeOperationFactory())
					.createEvaluationOp();
			fitness = evaluation.evaluateQuality(this);
		}
		return fitness;
	}

	@Override
	public List<Double> getGenes() {
		return genes;
	}
}
