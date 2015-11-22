package emas.operators.impl.intersection;

import emas.agents.Genotype;
import emas.operators.IEvaluation;
import emas.operators.IIntersection;

/**
 * Implementation of intersection operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Intersection implements IIntersection {

	private IEvaluation evaluation;

	public Intersection(IEvaluation evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public Genotype doIntersection(Genotype genotype1, Genotype genotype2) {
		return null;
	}

}
