package emas.agents.genotype;

import java.util.List;

import emas.agents.IGenotype;

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
