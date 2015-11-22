package emas.operators;

import emas.agents.Agent;

/**
 * Intersection operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IIntersection {

	/**
	 * Does intersection for provided pair of agents and returns newly created
	 * agent.
	 * 
	 * @param agent1
	 *            first agent
	 * @param agent2
	 *            second agent
	 * @return newly created agent
	 */
	public Agent doIntersection(Agent agent1, Agent agent2);
}
