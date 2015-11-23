package emas.core.providers;

import emas.agents.Agent;
import emas.agents.Genotype;

public class AgentFactory {

    public Agent getAgent(Genotype genotype) {
        return new Agent(genotype);
    }

    public Agent getAgent() {

        GenotypeFactory genFactory = new GenotypeFactory();
        return new Agent(genFactory.getGenotype());

    }
}
