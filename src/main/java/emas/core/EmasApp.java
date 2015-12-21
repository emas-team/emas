package emas.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.agents.Agent;
import emas.agents.Island;
import emas.agents.services.IService;
import emas.agents.services.MigrationService;
import emas.agents.services.ServiceEnum;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;
import emas.core.utils.ResultWriter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmasApp {

    private int max_generations;
    private int islands_number;
    private List<Island> islands;
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
        Logger.getAnonymousLogger().info("Done. See results in results csv file.");
    }

    private void loadParameters() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        Configuration config = injector.getInstance(Configuration.class);

        this.islands_number = config.getIntProperty("islands_number");
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
            Iterator<Agent> agentIterator = island.iterator();
            while (agentIterator.hasNext()) {
                Agent agent1 = agentIterator.next();
                IService service = agent1.getService();
                if (service.getServiceType() == ServiceEnum.MIGRATIONSERVICE) {
                    ((MigrationService)service).migrate(agent1, island, islands);
                } else if (agentIterator.hasNext()) {
                    Agent agent2 = agentIterator.next();
                    Agent newAgent = service.doAction(agent1, agent2);
                    if (newAgent.getEnergy() != 0) {
                        island.addAgent(newAgent);
                    }
                }
            }
            island.removeDeadAgents();
        }
        resultWriter.saveGeneration(islands);
    }
}
