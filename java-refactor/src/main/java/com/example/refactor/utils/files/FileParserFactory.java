package com.example.refactor.utils.files;

public class FileParserFactory {
    public static IFileParser getParser(String fileType) {
        switch (fileType.toLowerCase()) {
            case "json":
                return new JsonFileParser();
            default:
                throw new IllegalArgumentException("Type not supported: " + fileType);
        }
    }
}
