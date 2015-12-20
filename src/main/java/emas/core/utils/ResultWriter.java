package emas.core.utils;

import emas.agents.Agent;
import emas.agents.Island;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResultWriter {
    public static final String FILE_NAME = "results.csv";
    private List<Double> generations;
    private static final double WORST_VALUE = Double.MAX_VALUE;

    public ResultWriter() {
        generations = new LinkedList<>();
    }

    public void saveResults() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(FILE_NAME, "UTF-8");
        generations.forEach(writer::println);
        writer.close();
    }

    public void saveGeneration(List<Island> islands) {
        generations.add(getBest(islands));
    }

    public double getBest(List<Island> islands) {
        double best = WORST_VALUE;
        for (Island island : islands) {
            Iterator<Agent> agentIterator = island.iterator();
            while(agentIterator.hasNext()) {
                Agent agent = agentIterator.next();
                if (isBetter(agent.getFitness(), best)) {
                    best = agent.getFitness();
                }
            }
        }
        return best;
    }

    private boolean isBetter(double value, double best) {
        return value < best;
    }

}
