package emas.agents.services;

import emas.agents.Agent;
import emas.agents.Island;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Collections;
import java.util.Random;

public class MigrationService implements IService {
    @Override
    public Agent doAction(Agent agent1, Agent agent2) {
        throw new NotImplementedException();
    }

    @Override
    public ServiceEnum getServiceType() {
        return ServiceEnum.MIGRATIONSERVICE;
    }

    public void migrate(Agent agent, Island oldIsland, List<Island> islands){
        oldIsland.removeAgent(agent);

        Random randomizer = new Random();
        Island random = islands.get(randomizer.nextInt(islands.size()));

        random.addAgent(agent);
    }
}
