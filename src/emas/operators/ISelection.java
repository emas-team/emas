package emas.operators;

import java.util.List;

import emas.agents.Agent;

/**
 * Selection operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface ISelection {

	/**
	 * Removes worst agents.
	 * 
	 * @param agents
	 *            list of agents
	 */
	public void removeWorst(List<Agent> agents);

	/**
	 * Removes given number of worst agents.
	 * 
	 * @param agents
	 *            list of agents
	 * @param amount
	 *            amount of agents to remove
	 */
	public void removeWorst(List<Agent> agents, int amount);

}
