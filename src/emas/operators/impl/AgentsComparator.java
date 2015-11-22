package emas.operators.impl;

import java.util.Comparator;

import emas.agents.Agent;
import emas.operators.IEvaluation;

/**
 * Agent comparator. Provides implementation for comparing agents.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class AgentsComparator implements Comparator<Agent> {

	private IEvaluation qualityEvaluator;

	/**
	 * Constructor.
	 * 
	 * @param evaluator
	 *            evalutor that will be used to estimate agents quality
	 */
	public AgentsComparator(IEvaluation evaluator) {
		this.qualityEvaluator = evaluator;
	}

	@Override
	public int compare(Agent agent1, Agent agent2) {

		return (int) Math.signum(getQualityEvaluator().evaluateQuality(agent1)
				- getQualityEvaluator().evaluateQuality(agent2));
	}

	public IEvaluation getQualityEvaluator() {
		return qualityEvaluator;
	}

	public void setQualityEvaluator(IEvaluation qualityEvaluator) {
		this.qualityEvaluator = qualityEvaluator;
	}

}
