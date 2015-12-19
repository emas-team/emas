package emas.agents;

import emas.agents.genotype.Genotype;
import emas.agents.services.CrossoverService;
import emas.agents.services.IService;
import emas.agents.services.MeetingService;

import java.util.Random;

/**
 *
 */
public class Agent{
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

    public IService getService() {
        if(getEnergy() > 80){
            Random random = new Random();
            if(random.nextBoolean()){
                return new CrossoverService();
            }

        }
        return new MeetingService();
    }

    public double getFitness() {
        return getGenotype().evaluate();
    }

    public Integer getEnergy() {
        return energy;
    }

    public int lose() {
        int lose =  (new Double(Math.ceil(getEnergy() * 0.5))).intValue();
        setEnergy(getEnergy() - lose);
        return lose;
    }

    public void win(int energy) {
        setEnergy(getEnergy() + energy);
    }

    public int crossoverEnergy() {
        int lose = (new Double(Math.ceil(getEnergy() * 0.5))).intValue();
        setEnergy(getEnergy() - lose);
        return lose;
    }

    private void setEnergy(int energy){
        this.energy = energy;
    }
}
