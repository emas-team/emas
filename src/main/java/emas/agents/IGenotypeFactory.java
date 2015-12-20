package emas.agents;

import emas.agents.genotype.Genotype;

import java.util.List;

public interface IGenotypeFactory {
    Genotype createGenotype();
    Genotype createGenotype(List geneList);
}
