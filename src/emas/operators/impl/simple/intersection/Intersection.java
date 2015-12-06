package emas.operators.impl.simple.intersection;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;
import emas.operators.IIntersection;

/**
 * Implementation of intersection operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Intersection implements IIntersection<IGenotype> {

	private IEvaluation<IGenotype> evaluation;

	public Intersection(IEvaluation<IGenotype> evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public IGenotype doIntersection(IGenotype genotype1, IGenotype genotype2) {
		return null;
	}

}
