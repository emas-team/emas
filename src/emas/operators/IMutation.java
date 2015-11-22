package emas.operators;

import emas.agents.Agent;

/**
 * Mutation operation interface.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public interface IMutation {

	/**
	 * Takes agents current parameters and modifies it.
	 * 
	 * @param agent
	 */
	public void mutate(Agent agent);
}
