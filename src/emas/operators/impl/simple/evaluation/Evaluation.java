package emas.operators.impl.simple.evaluation;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;

/**
 * Implementation of evaluation operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Evaluation implements IEvaluation<IGenotype> {

	@Override
	public double evaluateQuality(IGenotype genotype) {
		return 0;
	}

}
