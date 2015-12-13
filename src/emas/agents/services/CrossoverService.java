package emas.agents.services;


import emas.agents.Agent;
import emas.agents.genotype.Genotype;
import emas.operators.IIntersection;

public class CrossoverService implements IService {
    public CrossoverService(){}
    public Agent crossover(Agent agent1, Agent agent2){
    	//TODO initialization here
        IIntersection intersection = null;
        Genotype newGenotype = (Genotype) intersection.doIntersection(agent1.getGenotype(), agent2.getGenotype());
        int energy = agent1.crossoverEnergy() + agent2.crossoverEnergy();
        return new Agent(newGenotype, energy);
    }
}
