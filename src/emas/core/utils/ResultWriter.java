package emas.core.utils;

import emas.agents.Agent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class ResultWriter {
    private List<Double> generations;
    private static final double WORST_VALUE = 0.;

    public ResultWriter() {
        generations = new LinkedList<>();
    }

    public void generateDiagram() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("results.csv", "UTF-8");
        generations.forEach(writer::println);
        writer.close();
    }

    public void saveGeneration(List<Agent> agents) {
        generations.add(getBest(agents));
    }

    public double getBest(List<Agent> agents) {
        double best = WORST_VALUE;
        for (Agent agent : agents) {
            if (isBetter(agent.evaluate(), best)) {
                best = agent.evaluate();
            }
        }
        return best;
    }

    private boolean isBetter(double value, double best) {
        return value > best;
    }

}
