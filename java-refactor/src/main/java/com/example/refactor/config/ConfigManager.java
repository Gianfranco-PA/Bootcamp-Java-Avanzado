package com.example.refactor.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);
    private static final String CONFIG_FILE = "config.properties";
    private static ConfigManager instance;
    private Properties properties;

    private ConfigManager() {
        properties = new Properties();
        try {
            LOGGER.info("Loading configuration from {}", CONFIG_FILE);
            properties.load(getClass().getClassLoader().getResourceAsStream(CONFIG_FILE));
            LOGGER.info("Configuration loaded successfully");
        } catch (IOException e) {
            LOGGER.error("Error loading configuration", e);
            throw new RuntimeException("Error loading configuration", e);
        }
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
