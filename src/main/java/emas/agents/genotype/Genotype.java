package emas.agents.genotype;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.agents.IGenotype;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;
import emas.operators.IEvaluation;
import emas.operators.impl.GenotypeOperationFactory;

public class Genotype implements IGenotype {

	private final List<Double> genes;
	private Double fitness;

	public Genotype() {
		Injector injector = Guice.createInjector(new ConfigurationModule());
		Configuration config = injector.getInstance(Configuration.class);

		int maxInit = config.getIntProperty("max_init");
		genes = new LinkedList<>();
		Random random = new Random();
		for (int i = 0; i < 2; i++) {
			Double d = random.nextDouble() * maxInit;
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
