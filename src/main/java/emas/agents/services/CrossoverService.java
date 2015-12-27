package emas.agents.services;


import emas.agents.Agent;
import emas.agents.genotype.Genotype;
import emas.operators.IIntersection;
import emas.operators.IMutation;
import emas.operators.impl.GenotypeOperationFactory;

public class CrossoverService implements IService {
    @Override
    public Agent doAction(Agent agent1, Agent agent2) {
        GenotypeOperationFactory factory = new GenotypeOperationFactory();
        IIntersection intersection = factory.createIntersectionOp();
        Genotype newGenotype = (Genotype) intersection.doIntersection(agent1.getGenotype(), agent2.getGenotype());
        IMutation mutation = factory.createMutationOp();
        mutation.mutate(newGenotype);
        int energy = agent1.crossoverEnergy() + agent2.crossoverEnergy();
        return new Agent(newGenotype, energy);
    }

    @Override
    public ServiceEnum getServiceType() {
        return ServiceEnum.CROSSOVERSERVICE;
    }
}
