package emas.operators.impl.simple.mutation;

import java.util.LinkedList;
import java.util.List;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;
import emas.operators.IMutation;
import emas.operators.impl.simple.evaluation.Evaluation;

/**
 * Implementation of mutation operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Mutation implements IMutation<IGenotype> {

	IEvaluation<IGenotype> evaluation;
	private List<Double> mutatedList = new LinkedList<Double>();
	Double max = Double.NEGATIVE_INFINITY;
	Double min = Double.POSITIVE_INFINITY;
	Double range;

	/**
	 * Default constructor. Sets the default evaluation method.
	 */
	public Mutation() {
		this(new Evaluation());
	}

	/**
	 * Constructor.
	 */
	public Mutation(IEvaluation<IGenotype> evaluation) {
		this.evaluation = evaluation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mutate(IGenotype genotype) {
		if (genotype == null) {
			throw new IllegalArgumentException("Genotype cannot be null.");
		}
		List<Double> list = genotype.getList();
		list.forEach(value -> {
			if (value < min) {
				min = value;
			}
			if (value > max) {
				max = value;
			}
		});

		range = max - min;

		list.forEach(value -> getMutatedList().add(
				new Double(value + (Math.random() - 0.5) * range)));

		synchronized (genotype) {
			genotype.getList().clear();
			// TODO should we check here if the list after mutation is evaluated
			// as better one or not? If mutated list is worse we can leave list
			// as is.
			genotype.getList().addAll(getMutatedList());
		}

	}

	private List<Double> getMutatedList() {
		return mutatedList;
	}

}
