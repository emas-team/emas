package emas.core.utils;

import emas.agents.Agent;
import emas.agents.IAgent;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

    public void saveGeneration(List<Agent> agents) {
        generations.add(getBest(agents));
    }

    public double getBest(List<Agent> agents) {
        double best = WORST_VALUE;
        for (IAgent agent : agents) {
            if (isBetter(agent.evaluate(), best)) {
                best = agent.evaluate();
            }
        }
        return best;
    }

    private boolean isBetter(double value, double best) {
        return value < best;
    }

}
