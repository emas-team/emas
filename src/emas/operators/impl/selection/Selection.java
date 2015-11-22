package emas.operators.impl.selection;

import java.util.Comparator;
import java.util.List;

import emas.agents.Genotype;
import emas.operators.IEvaluation;
import emas.operators.ISelection;
import emas.operators.impl.GenotypeComparator;

/**
 * Implementation of selection operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Selection implements ISelection {

	private Comparator<Genotype> genotypeComparator;

	public Selection(IEvaluation evaluationMethod) {
		this(new GenotypeComparator(evaluationMethod));
	}

	public Selection(Comparator<Genotype> genotypeComparator) {
		this.genotypeComparator = genotypeComparator;
	}

	@Override
	public Genotype getWorst(List<Genotype> genotypes) {
		if (genotypes == null || genotypes.isEmpty()) {
			return null;
		}
		return worst(genotypes);
	}

	@Override
	public List<Genotype> getWorst(List<Genotype> genotypes, int amount) {
		if (genotypes == null) {
			return null;
		} else if (genotypes.size() < amount) {
			return genotypes;
		} else {
			genotypes.sort(genotypeComparator);
			return genotypes.subList(0, amount - 1);
		}
	}

	public Genotype worst(List<Genotype> genotypes) {
		if (genotypes == null || genotypes.isEmpty()) {
			return null;
		}
		Genotype worst = genotypes.get(0);
		for (Genotype current : genotypes) {
			if (genotypeComparator.compare(worst, current) > 0) {
				worst = current;
			}
		}
		return worst;
	}

}
