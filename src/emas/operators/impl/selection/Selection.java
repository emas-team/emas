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
	public void removeWorst(List<Genotype> genotypes) {
		if (genotypes == null || genotypes.isEmpty()) {
			return;
		}
		genotypes.remove(worst(genotypes));
	}

	@Override
	public void removeWorst(List<Genotype> genotypes, int amount) {
		if (genotypes == null) {
			return;
		} else if (genotypes.size() < amount) {
			genotypes.clear();
		} else {
			genotypes.sort(genotypeComparator);
			for (int i = 0; i < amount; i++) {
				genotypes.remove(0);
			}
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
