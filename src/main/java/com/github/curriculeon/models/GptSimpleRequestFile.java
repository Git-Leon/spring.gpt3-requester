package com.github.curriculeon.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GptSimpleRequestFile {
    private String prompt;
    private String token;

    public GptSimpleRequestFile() {
    }

    public GptSimpleRequestFile(String prompt, String token) {
        this.prompt = prompt;
        this.token = token;
    }

    public GptSimpleRequestFile(File file, String token) {
        this(readFile(file), token);
    }

    private static String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return sb.toString();
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
