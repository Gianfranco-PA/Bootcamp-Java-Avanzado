package com.example.refactor.utils.files;

import java.io.File;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceFileLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFileLoader.class);
    public static File getFileFromResources(String fileName) {
        LOGGER.info("Trying to load file '{}' from resources", fileName);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // We should check if the resource is null
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            LOGGER.error("File '{}' not found in classpath resources", fileName);
            throw new IllegalArgumentException("File '" + fileName + "' not found");
        }

        File file = new File(resource.getFile());
        if (!file.exists() || !file.canRead()) {
            // We need a more descriptive message
            // throw new IllegalArgumentException("Missing file");
            LOGGER.error("File '{}' exists but cannot be read", fileName);
            throw new IllegalArgumentException("File '" + fileName + "' not found or cannot be read");
        }

        LOGGER.info("Successfully loaded file '{}'", fileName);
        return file;
    }
}
