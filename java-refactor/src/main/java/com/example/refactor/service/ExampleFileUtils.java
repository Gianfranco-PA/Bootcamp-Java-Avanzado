package com.example.refactor.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

//It is not necessary
public class ExampleFileUtils {

    public static JSONObject getJsonFromFile(File inputSource) {
        JSONParser parser = new JSONParser();
        //We should close the file reader
        try (FileReader fileReader = new FileReader(inputSource)) {
            return (JSONObject) parser.parse(fileReader);
        } catch (IOException | ParseException e) {
            //It is not a good practice show the stack trace to the user
            e.printStackTrace();
        }

        return null;
    }

    public static File getFileFromResources(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //We should check if the resource is null
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File '" + fileName + "' not found");
        }

        File file = new File(resource.getFile());
        if (!file.exists() || !file.canRead()) {
            //We need a more descriptive message
            //throw new IllegalArgumentException("Missing file");
            throw new IllegalArgumentException("File '" + fileName + "' not found or cannot be read");
        }
        return file;
    }

}
