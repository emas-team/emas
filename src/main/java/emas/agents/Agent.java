package emas.agents;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.agents.genotype.Genotype;
import emas.agents.services.CrossoverService;
import emas.agents.services.IService;
import emas.agents.services.MeetingService;
import emas.agents.services.MigrationService;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;

import java.util.Random;

/**
 *
 */
public class Agent{
    private final Genotype genotype;
    private Integer energy;
    private Double fitness;

    private static Integer minCrossoverEnergy;
    private static Integer minMigrationEnergy;
    private static double crossoverProbability;
    private static double migrationProbability;

    public Agent(){
        this.genotype = new Genotype();
        this.energy = 100;

        loadConfig();
    }

    public Agent(Genotype genotype, Integer energy){
        this.genotype = genotype;
        this.energy = energy;

        loadConfig();
    }

    private void loadConfig(){
        if(minCrossoverEnergy == null) {
            Injector injector = Guice.createInjector(new ConfigurationModule());
            Configuration config = injector.getInstance(Configuration.class);

            minCrossoverEnergy = config.getIntProperty("min_crossover_energy");
            minMigrationEnergy = config.getIntProperty("min_migration_energy");
            crossoverProbability = config.getIntProperty("crossover_probability") * 1.0 / 100;
            migrationProbability = config.getIntProperty("migration_probability") * 1.0 / 100;
        }
    }

    public Genotype getGenotype() {
        return genotype;
    }

    public IService getService() {
        Random random = new Random();
        double luckyNumber = random.nextDouble();
        // TODO: minMigrationEnergy
        if(minCrossoverEnergy<energy) {
            if (crossoverProbability > luckyNumber) {
                return new CrossoverService();
            } else if (crossoverProbability + migrationProbability > luckyNumber) {
                return new MigrationService();
            }
        }
        return new MeetingService();
    }

    public double getFitness() {
        return genotype.evaluate();
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
