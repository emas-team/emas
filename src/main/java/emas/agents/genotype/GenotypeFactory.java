package emas.agents.genotype;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.agents.IGenotype;
import emas.agents.exceptions.GenotypeNotFoundException;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GenotypeFactory {

    private GenotypeFactory() {
    }

    @SuppressWarnings("unchecked")
    public static IGenotype createGenotype() {
        IGenotype genotype;
        try {
            Class<?> clazz = Class.forName(getClassName());
            Constructor<?> constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            genotype = (IGenotype) object;
        } catch (InstantiationException e) {
            throw new GenotypeNotFoundException(e);
        } catch (InvocationTargetException e) {
            throw new GenotypeNotFoundException(e);
        } catch (NoSuchMethodException e) {
            throw new GenotypeNotFoundException(e);
        } catch (IllegalAccessException e) {
            throw new GenotypeNotFoundException(e);
        } catch (ClassNotFoundException e) {
            throw new GenotypeNotFoundException(e);
        }
        return genotype;
    }

    private static String getClassName() {
        Injector injector = Guice.createInjector(new ConfigurationModule());
        Configuration config = injector.getInstance(Configuration.class);

        return config.getStringProperty("genotype_class");
    }
}