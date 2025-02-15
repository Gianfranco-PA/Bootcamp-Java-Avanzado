package com.example.refactor.utils.files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.example.refactor.exception.JsonParsingException;

public class JsonValidationUtils {

    /**
     * Validates that a key exists in the JSON object.
     */
    public static void validateKeyExists(JSONObject jsonObject, String key, String context) {
        if (!jsonObject.containsKey(key)) {
            throw new JsonParsingException("The object '" + context + "' does not contain the key '" + key + "'");
        }
    }

    /**
     * Gets a String from the JSON object.
     */
    public static String getString(JSONObject jsonObject, String key, String context) {
        validateKeyExists(jsonObject, key, context);
        Object value = jsonObject.get(key);
        if (!(value instanceof String stringValue)) {
            throw new JsonParsingException("The value for the key '" + key + "' in " + context + " is not a String");
        }
        return stringValue;
    }

    /**
     * Gets a Boolean from the JSON object.
     */
    public static Boolean getBoolean(JSONObject jsonObject, String key, String context) {
        validateKeyExists(jsonObject, key, context);
        Object value = jsonObject.get(key);
        if (!(value instanceof Boolean booleanValue)) {
            throw new JsonParsingException("The value for the key '" + key + "' in " + context + " is not a Boolean");
        }
        return booleanValue;
    }

    /**
     * Gets an Integer from the JSON object.
     */
    public static int getInt(JSONObject jsonObject, String key, String context) {
        validateKeyExists(jsonObject, key, context);
        Object value = jsonObject.get(key);
        if (!(value instanceof Number numberValue)) {
            throw new JsonParsingException("The value for the key '" + key + "' in " + context + " is not a Number");
        }
        return numberValue.intValue();
    }
    
    /**
     * Gets a JSONArray from the JSON object and validates that it is not empty.
     */
    public static JSONArray getJSONArray(JSONObject jsonObject, String key, String context) {
        validateKeyExists(jsonObject, key, context);
        Object value = jsonObject.get(key);
        if (!(value instanceof JSONArray jsonArrayValue)) {
            throw new JsonParsingException("The key '" + key + "' is not an array in " + context);
        }
        if (jsonArrayValue.isEmpty()) {
            throw new JsonParsingException("The array '" + key + "' is empty in " + context);
        }
        return jsonArrayValue;
    }
}
