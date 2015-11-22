package emas.operators.impl.selection;

import java.util.Comparator;
import java.util.List;

import emas.agents.Agent;
import emas.operators.IEvaluation;
import emas.operators.ISelection;
import emas.operators.impl.AgentsComparator;

/**
 * Implementation of selection operation.
 * 
 * @author Klaudia Bałazy, Robert Poparda
 */
public class Selection implements ISelection {

	private Comparator<Agent> agentComparator;

	public Selection(IEvaluation evaluationMethod) {
		this(new AgentsComparator(evaluationMethod));
	}

	public Selection(Comparator<Agent> agentComparator) {
		this.agentComparator = agentComparator;
	}

	@Override
	public void removeWorst(List<Agent> agents) {
		if (agents == null || agents.isEmpty()) {
			return;
		}
		agents.remove(worst(agents));
	}

	@Override
	public void removeWorst(List<Agent> agents, int amount) {
		if (agents == null) {
			return;
		} else if (agents.size() < amount) {
			agents.clear();
		} else {
			agents.sort(agentComparator);
			for (int i = 0; i < amount; i++) {
				agents.remove(0);
			}
		}
	}

	public Agent worst(List<Agent> agents) {
		if (agents == null || agents.isEmpty()) {
			return null;
		}
		Agent worst = agents.get(0);
		for (Agent current : agents) {
			if (agentComparator.compare(worst, current) > 0) {
				worst = current;
			}
		}
		return worst;
	}

}
