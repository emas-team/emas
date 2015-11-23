package emas.core.providers;

import emas.agents.Agent;

import java.util.Collection;

public class NeighbourProvider {
    private Collection<Agent> agents;

    public NeighbourProvider(Collection<Agent> agents) {
        this.agents = agents;
    }

    public Agent getNeighbour() {
        return null;
    }

}
