package emas.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.agents.Agent;
import emas.agents.services.IService;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;
import emas.core.utils.ResultWriter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmasApp {

    private int agents_number;
    private int max_generations;
    private int islands_number;
    private List<Island> islands;
    private List<Agent> agents;
    private List<Agent> agentsToDelete;
    private ResultWriter resultWriter;

    public void start() {
        loadParameters();
        createIslands();
        resultWriter = new ResultWriter();

        for (int generation = 0; generation < max_generations; generation++) {
            performGenerationActions();
        }
        try {
            resultWriter.saveResults();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            Logger.getLogger(EmasApp.class.toString()).log(Level.SEVERE,
                    "Could not write results to file.", e);
        }
        System.out.println("Done. See results in results csv file.");
    }

    private void loadParameters() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        Configuration config = injector.getInstance(Configuration.class);

        this.islands_number = config.getIntProperty("agents_number");
        this.max_generations = config.getIntProperty("max_generations");
    }

    private void createIslands() {
        islands = new ArrayList(islands_number);
        for (int i = 0; i < islands_number; i++) {
            islands.add(new Island());
        }
    }

    private void performGenerationActions() {
        for (Island island : islands) {
            while (island.hasNext()) {
                Agent agent1 = island.next();
                IService service = agent1.getService();
                if (service.getType() == service.MIGRATE) {
                    (MigrationService) service.migrate(agent1, islands);
                } else if (island.hasNext()) {
                    Agent agent2 = iterator.next();
                    Agent newAgent = service.doAction(agent1, agent2);
//                        verifyIfAgentIsAlive(agent1);
//                        verifyIfAgentIsAlive(agent2);
                    if (verifyIfAgentIsAlive(newAgent)) {
                        island.addAgent(newAgent);
                    }
                }
            }
            island.removeDeadAgents();
        }
        resultWriter.saveGeneration(agents);
    }

    private boolean verifyIfAgentIsAlive(Agent agent) {
        if (agent.getEnergy() == 0) {
            agentsToDelete.add(agent);
            return false;
        }
        return true;
    }
}
