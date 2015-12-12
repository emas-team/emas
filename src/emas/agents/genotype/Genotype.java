package emas.agents.genotype;

import emas.agents.IGenotype;

import java.util.List;

public class Genotype implements IGenotype {

    private List geneList;
    public Genotype(){

    }

    public Genotype(List geneList){

    }

    @Override
    public Double evaluate() {
        return null;
    }

    @Override
    public List getList(){
        return geneList;
    }
}
