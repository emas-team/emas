package emas.agents;

import emas.agents.genotype.Genotype;
import emas.agents.services.CrossoverService;
import emas.agents.services.IService;
import emas.agents.services.MeetingService;

import java.util.Random;

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
    public IService getService() {
        if(getEnergy() > 80){
            Random random = new Random();
            if(random.nextBoolean()){
                return new CrossoverService();
            }

        }
        return new MeetingService();
    }

    @Override
    public double evaluate() {
        return getGenotype().evaluate();
    }

    public Integer getEnergy() {
        return energy;
    }

    public int lose() {
        int lose = (int)(getEnergy() * 0.2) + 20;
        if(lose>getEnergy()){
            lose = getEnergy();
        }
        energy -= lose;
        return lose;
    }

    public void win(int energy) {
        this.energy += energy;
    }

    public int crossoverEnergy() {
        int lose = (int)(getEnergy() * 0.3);
        energy -= lose;
        return lose;
    }
}
