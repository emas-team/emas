package emas.operators.impl.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import emas.agents.IGenotype;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;

/**
 * Class that retrieves elements from XML and returns them if needed.
 * 
 * @author Klaudia Balazy, Robert Poparda
 *
 */
public class ParametersHolder {
	private static final ParametersHolder INSTANCE = new ParametersHolder();
	private static Double a;
	private static Class<IGenotype> type;
	private Configuration config;

	@SuppressWarnings("unchecked")
	private ParametersHolder() {
		Injector injector = Guice.createInjector(new ConfigurationModule());
		config = injector.getInstance(Configuration.class);

		ParametersHolder.a = Double.parseDouble(config
				.getStringProperty("rastrigin_A"));

		try {
			ParametersHolder.type = (Class<IGenotype>) Class
					.forName(config.getStringProperty("genotype_class"));
		} catch (ClassNotFoundException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE,
					"Cannot find class referenced in XML file.");
		}
	}

	public static ParametersHolder getInstance() {
		return INSTANCE;
	}

	public static synchronized double getA() {
		return a;
	}

	public static Class<IGenotype> getGenotypeClass() {
		return type;
	}

	public static void setA(Double a) {
		ParametersHolder.a = a;
	}

	public static void setType(Class<IGenotype> clazz) {
		ParametersHolder.type = clazz;
	}

}
