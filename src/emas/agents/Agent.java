package emas.agents;

import emas.agents.genotype.Genotype;
import emas.agents.services.IService;

/**
 *
 */
public class Agent implements IAgent{
    private Genotype genotype;
    private Integer energy;

    public Agent(){
        this.genotype = new Genotype();
        this.energy = 100;
    }

    public Agent(Genotype genotype, Integer energy){
        this.genotype = genotype;
        this.energy = energy;
    }

    public Genotype getGenotype() {
        return genotype;
    }

    @Override
    public IService getAction() {

        return null;
    }

    @Override
    public double evaluate() {
        return getGenotype().evaluate();
    }

    public Integer getEnergy() {
        return energy;
    }

    public int lose() {
        int lose = (int)(energy * 0.2) + 20;
        if(lose>energy){
            lose = energy;
        }
        energy -= lose;
        return lose;
    }

    public void win(int energy) {
        this.energy += energy;
    }

    public int crossoverEnergy() {
        int lose = (int)(energy * 0.3);
        energy -= lose;
        return lose;
    }
}
