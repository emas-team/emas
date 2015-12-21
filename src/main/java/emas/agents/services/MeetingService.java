package emas.agents.services;

import emas.agents.Agent;
import emas.core.utils.Configuration;

public class MeetingService implements IService {

	private static final double SIGN_A = Math.signum(new Configuration()
			.getIntProperty("rastrigin_A"));

	public MeetingService() {
	}

	@Override
	public Agent doAction(Agent agent1, Agent agent2) {
		if (SIGN_A * (agent1.getFitness() - agent2.getFitness()) < 0) {
			int energy = agent2.lose();
			agent1.win(energy);
		} else if (SIGN_A * (agent1.getFitness() - agent2.getFitness()) > 0) {
			int energy = agent1.lose();
			agent2.win(energy);
		}
		return new Agent(null, 0);
	}

	@Override
	public ServiceEnum getServiceType() {
		return ServiceEnum.MEETINGSERVICE;
	}
}
