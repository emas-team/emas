package emas.agents.genotype;

import com.google.inject.Guice;
import com.google.inject.Injector;
import emas.agents.IGenotype;
import emas.agents.genotype.exceptions.GenotypeNotFoundException;
import emas.core.utils.Configuration;
import emas.core.utils.ConfigurationModule;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GenotypeFactory {

    @SuppressWarnings("unchecked")
    public static IGenotype createGenotype(){
        Injector injector = Guice.createInjector(new ConfigurationModule());
        Configuration config = injector.getInstance(Configuration.class);

        String className = config.getStringProperty("genotype_class");
        IGenotype genotype;
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            genotype = (IGenotype) object;
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new GenotypeNotFoundException();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new GenotypeNotFoundException();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new GenotypeNotFoundException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new GenotypeNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new GenotypeNotFoundException();
        }
        return genotype;
    }
}
