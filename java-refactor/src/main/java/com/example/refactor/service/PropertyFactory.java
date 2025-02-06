package com.example.refactor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//It is not necessary
public class PropertyFactory {

    private static final Properties properties;
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyFactory.class);
    private static final String CONFIG_FILE = "config.properties";

    static {
        properties = new Properties();
        
        try (InputStream inputStream = PropertyFactory.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            //We should check if the input stream is null
            if (inputStream == null) {
                throw new IllegalArgumentException("Configuration file '" + CONFIG_FILE + "' not found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("ERROR while reading the configuration file: {}", e.getMessage());
            //It is redundant to print the stack trace here and not is a good practice show the stack trace to the user
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE, e);
        }
    }

    public static Properties getProperties(){
        return properties;
    }

}
