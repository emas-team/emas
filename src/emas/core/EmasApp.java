package emas.core;

import com.google.inject.Guice;
import com.google.inject.Injector;

import emas.agents.Agent;
import emas.agents.services.IService;
import emas.core.utils.ResultWriter;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmasApp {

    private int agents_number;
    private int max_generations;
    private List<Agent> agents;
    ResultWriter resultWriter;

    public void start() {
        loadParameters();
        createAgents();
        resultWriter = new ResultWriter();

        for (int generation = 0; generation < max_generations; generation++) {
            performGenerationActions();
        }
        try {
            resultWriter.generateDiagram();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            Logger.getLogger(EmasApp.class.toString()).log(Level.SEVERE, "Could not write results to file.", e);
        }
    }

    private void loadParameters() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        Configuration config = injector.getInstance(Configuration.class);

        this.agents_number = config.getIntProperty("agents");
        this.max_generations = config.getIntProperty("max_generations");
    }

    private void createAgents() {
        agents = new LinkedList<>();
        for (int i = 0; i < agents_number; i++) {
            agents.add(new Agent());
        }
    }

    private void performGenerationActions() {
        List<Agent> newAgents = new LinkedList<>();
        for (Iterator<Agent> iterator = agents.iterator(); iterator.hasNext(); ) {
            Agent agent1 = iterator.next();
            Agent agent2 = iterator.next();
            Agent newAgent = agent1.getService().doAction();
            verifyIfAgentIsAlive(agent1);
            verifyIfAgentIsAlive(agent2);
            if(verifyIfAgentIsAlive(newAgent)) {
                newAgents.add(newAgent);
            }
        }
        agents.addAll(newAgents);
        resultWriter.saveGeneration(agents);
    }

    private boolean verifyIfAgentIsAlive(Agent agent) {
        if (agent.evaluate() == 0) {
            agents.remove(agent);
            return false;
        }
        return true;
    }
}
