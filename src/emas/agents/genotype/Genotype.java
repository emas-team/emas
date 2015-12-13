package emas.agents.genotype;

import java.util.LinkedList;
import java.util.List;

import emas.agents.IGenotype;

public class Genotype implements IGenotype {

	private List<Object> geneList = new LinkedList<>();

	public Genotype() {

	}

	public Genotype(List<Object> geneList) {

	}

	@Override
	public Double evaluate() {
		return null;
	}

	@Override
	public List<Object> getList() {
		return geneList;
	}
}
