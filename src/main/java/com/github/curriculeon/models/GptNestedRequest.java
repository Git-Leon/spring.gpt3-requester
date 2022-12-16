package com.github.curriculeon.models;

public class GptNestedRequest {
    private String token;
    private String prompt;
    private int n;

    public GptNestedRequest(String token, String prompt, int n) {
        this.token = token;
        this.prompt = prompt;
        this.n = n;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
