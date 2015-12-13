package emas.agents.services;

import emas.agents.Agent;

public class MeetingService implements IService{
    public MeetingService(){}
    @Override
    public Agent doAction(Agent agent1, Agent agent2) {
        if(agent1.evaluate() > agent2.evaluate()){
            int energy = agent2.lose();
            agent1.win(energy);
        } else if (agent1.evaluate() < agent2.evaluate()) {
            int energy = agent1.lose();
            agent2.win(energy);
        }
        return new Agent(null, 0);
    }
}
