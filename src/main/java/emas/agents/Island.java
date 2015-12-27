package emas.agents;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;

import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Island implements Iterable<Agent> {
    private final List<Agent> inhabitants = new LinkedList<>();
    private final List<Agent> deadAgents = new LinkedList<>();
    private final List<Agent> newAgents = new LinkedList<>();

    public Island() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        Configuration config = injector.getInstance(Configuration.class);

        int inhabitantsNumber = config.getIntProperty("island_size");
        initializeAgents(inhabitantsNumber);
    }

    private void initializeAgents(int quantity) {
        for (int i = 0; i < quantity; i++) {
            inhabitants.add(new Agent());
        }
    }

    @Override
    public Iterator<Agent> iterator() {
        return inhabitants.iterator();
    }

    public void addAgent(Agent agent) {
        newAgents.add(agent);
    }

    private void addNewAgents() {
        for (Agent agent : newAgents) {
            inhabitants.add(agent);
        }
    }

    private void findDeadAgents() {
        for (Agent agent : inhabitants) {
            if (agent.getEnergy() == 0) {
                deadAgents.add(agent);
            }
        }
    }

    private void clearDeadAgents() {
        for (Agent agent : deadAgents) {
            inhabitants.remove(agent);
        }
        deadAgents.clear();
    }

    public void removeDeadAgents() {
        addNewAgents();
        findDeadAgents();
        clearDeadAgents();
        Collections.shuffle(inhabitants);
    }

    public void removeAgent(Agent agent) {
        deadAgents.add(agent);
    }
}
