package emas.core.utils;

import emas.agents.Agent;

import java.util.Collection;

public class ResultWriter {
    private Collection<Double> generations;
    private Collection<Agent> agents;

    public void generateDiagram() {

    }

    public void saveGeneration() {
        getBest();
    }

    public double getBest() {
        return 0.;
    }

}
