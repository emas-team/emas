package emas.core;

import emas.agents.Agent;
import emas.agents.Genotype;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EmasApp {

    private static final int AGENTS = 10;
    private static final int MAX_GENERATIONS = 1000;
    private List<Agent> agents;
    private Random random;
    private CrossoverService crossoverService;
    private MeetingService meetingService;

    public EmasApp() {
        random = new Random();
    }

    public void start() {
        createAgents();
        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            performGenerationActions();
        }
    }

    private void createAgents() {
        agents = new LinkedList<>();
        for (int i = 0; i < AGENTS; i++) {
            agents.add(new Agent(new Genotype())); //TODO: Probably the new Genotype should be created in Agent's constructor
        }
    }

    private void performGenerationActions() {
        List<Agent> newAgents = new LinkedList<>();
        for (Iterator<Agent> iterator = agents.iterator(); iterator.hasNext(); ) {
            Agent agent1 = iterator.next();
            Agent agent2 = iterator.next();
            if (random.nextBoolean()) {
                newAgents.add(crossoverService.perform(agent1, agent2));
            } else {
                meetingService.perform(agent1, agent2);
            }
            verifyIfAgentIsAlive(agent1);
            verifyIfAgentIsAlive(agent2);
        }
        agents.addAll(newAgents);
    }

    private void verifyIfAgentIsAlive(Agent agent) {
        if (agent.getFitness() == 0) {
            agents.remove(agent);
        }
    }
}
