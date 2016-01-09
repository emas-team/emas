package emas.agents.services;


import emas.agents.Agent;

public interface IService {
    Agent doAction(Agent agent1, Agent agent2);

    ServiceEnum getServiceType();
}
