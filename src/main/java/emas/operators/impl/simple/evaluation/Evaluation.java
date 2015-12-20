package emas.operators.impl.simple.evaluation;

import java.util.List;

import emas.agents.IGenotype;
import emas.operators.IEvaluation;
import emas.operators.impl.utils.ParametersHolder;

/**
 * Implementation of evaluation operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Evaluation implements IEvaluation<IGenotype> {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public double evaluateQuality(IGenotype genotype) {
		List<Double> pointsList = null;
		pointsList = (List<Double>) genotype.getGenes();

		if (pointsList == null || pointsList.size() == 0) {
			throw new IllegalArgumentException("Unable to evaluate genotype.");
		}
		try {
			return evalRastriginFunction(pointsList);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Unexpected genotype class.", e);
		}
	}

	private double evalRastriginFunction(List<Double> pointsList) {
		double a = ParametersHolder.getA();
		double n = pointsList.size();
		double sum = a * n;
		return pointsList.stream().reduce(
				sum,
				(acc, value) -> {
					return acc + Math.pow(value, 2) - a
							* Math.cos(2 * Math.PI * value);
				});
	}
}
