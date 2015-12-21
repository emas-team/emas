package emas.agents.services;

import emas.agents.Agent;

public class MeetingService implements IService{
    public MeetingService(){}
    @Override
    public Agent doAction(Agent agent1, Agent agent2) {
        if(agent1.getFitness() < agent2.getFitness()){
            int energy = agent2.lose();
            agent1.win(energy);
        } else if (agent1.getFitness() > agent2.getFitness()) {
            int energy = agent1.lose();
            agent2.win(energy);
        }
        return new Agent(null, 0);
    }

    @Override
    public ServiceEnum getServiceType() {
        return ServiceEnum.MEETINGSERVICE;
    }
}
