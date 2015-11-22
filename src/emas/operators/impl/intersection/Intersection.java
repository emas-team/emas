package emas.operators.impl.intersection;

import emas.agents.Agent;
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
	public Agent doIntersection(Agent agent1, Agent agent2) {
		return null;
	}

}
