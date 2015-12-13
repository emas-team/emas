package emas.agents;

import emas.agents.services.IService;

/**
 *
 */
public interface IAgent {
    IService getService();
    double evaluate();
}
