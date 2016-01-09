package emas.agents;

import java.util.List;

public interface IGenotype {
    Double evaluate();

    List getGenes();
}
