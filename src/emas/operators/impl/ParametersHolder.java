package emas.operators.impl;

import emas.agents.IGenotype;

/**
 * Class that retrieves elements from XML and returns them if needed.
 * 
 * @author Klaudia Balazy, Robert Poparda
 *
 */
public class ParametersHolder {
	private static final ParametersHolder INSTANCE = new ParametersHolder();
	private static Double a;
	private static Class<? extends IGenotype> type;

	private ParametersHolder() {
	}

	public static ParametersHolder getInstance() {
		return INSTANCE;
	}

	public static synchronized double getA() {
		if (a == null) {
			// zaczytaj z XML'a
		}
		return a;
	}

	public static Class<? extends IGenotype> getGenotypeClass() {
		if (type == null) {
			// zaczytaj z XML'a
		}
		return type;
	}

}
