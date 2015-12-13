package emas.agents;

import emas.agents.services.IService;

/**
 *
 */
public interface IAgent {
    IService getAction();
    double evaluate();
}
