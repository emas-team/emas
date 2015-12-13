package emas.agents.services;

import emas.agents.Agent;

public class MeetingService implements IService{
    public MeetingService(){}
    public Agent meet(Agent agent1, Agent agent2){
        if(agent1.evaluate() > agent2.evaluate()){
            int energy = agent2.lose();
            agent1.win(energy);
        } else if (agent1.evaluate() < agent2.evaluate()){
            int energy = agent1.lose();
            agent2.win(energy);
        }
        if (agent1.getEnergy() == 0) {
            return agent1;
        } else if (agent2.getEnergy() == 0){
            return agent2;
        } else {
            return null;
        }
    }
}
