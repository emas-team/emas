package emas.core.utils;

import emas.core.interfaces.IResourceProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration implements IResourceProvider {
    private Properties properties;

    public Configuration(String file) {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(file);
            properties.load(input);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getCanonicalName())
            	.log(Level.SEVERE, "Problem with reading config file.");
        }
    }

    public Configuration() {
        this("config/configuration.properties");
    }

    @Override
    public int getIntProperty(String property) {
        return Integer.parseInt(properties.getProperty(property));
    }

    @Override
    public String getStringProperty(String property) {
        return properties.getProperty(property);
    }
}
