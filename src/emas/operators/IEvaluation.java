package emas.operators;

import emas.agents.Agent;

/**
 * Evaluation operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IEvaluation {

	/**
	 * Evaluates quality of an agent. The higher value is returned the better
	 * agent was evaluated.
	 * 
	 * Range of returned value: [0.0;1.0].
	 * 
	 * @param agent
	 *            agent to be evaluated
	 * @return result of evaluation
	 */
	public double evaluateQuality(Agent agent);
}
