package emas.agents.genotype;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;
import emas.operators.impl.GenotypeOperationFactory;

public class Genotype implements IGenotype {

	private List<Object> geneList;
	private Double fitness = -1.0;

	public Genotype() {
		geneList  = new LinkedList<>();
		Random random = new Random();
		for(int i = 0; i<2; i++){
			Double d = random.nextDouble();
			geneList.add(d);
		}
	}

	public Genotype(List<Object> geneList) {
		this.geneList = geneList;
	}

	@Override
	public Double evaluate() {
		if(fitness == -1){
			IEvaluation evaluation = (new GenotypeOperationFactory()).createEvaluationOp();
		}
		return fitness;
	}

	@Override
	public List<Object> getList() {
		return geneList;
	}
}
