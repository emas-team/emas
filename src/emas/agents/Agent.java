package emas.agents;

/**
 *
 */
public class Agent implements IAgent{
    private Genotype genotype;
    private Integer energy;

    public Agent(Genotype genotype){
        this.genotype = genotype;
        this.energy = 100;
    }

    public Agent(Genotype genotype, Integer energy){
        this.genotype = genotype;
        this.energy = energy;
    }

    private void crossover(){

    }

    public int evaluation(Agent agent){

        return 0;
    }

    public void crossover(AgentHelper agentHelper){

    }

    public void chooseAction(Agent agent, Integer energy){

    }

    @Override
    public void performAction() {

    }
}
