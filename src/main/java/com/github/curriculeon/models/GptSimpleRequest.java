package com.github.curriculeon.models;

public class GptSimpleRequest {
    private String prompt;
    private String token;

    public GptSimpleRequest() {
    }

    public GptSimpleRequest(String prompt, String token) {
        this.prompt = prompt;
        this.token = token;
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
