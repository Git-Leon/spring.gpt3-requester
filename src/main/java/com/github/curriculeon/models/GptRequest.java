package com.github.curriculeon.models;

import java.util.HashMap;
import java.util.Map;

public class GptRequest {
    private String model = "text-davinci-003";
    private String prompt;
    private Double temperature = 0.5;
    private Integer max_tokens = 2048;
    private Integer top_p = 1;
    private Integer frequency_penalty = 0;
    private Integer presence_penalty = 0;

    public GptRequest(String prompt) {
        this("text-davinci-003", prompt, 0.5, 2048, 1, 0, 0);
    }

    public GptRequest(String model, String prompt, Double temperature, Integer max_tokens, Integer top_p, Integer frequency_penalty, Integer presence_penalty) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
        this.top_p = top_p;
        this.frequency_penalty = frequency_penalty;
        this.presence_penalty = presence_penalty;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Integer getTop_p() {
        return top_p;
    }

    public void setTop_p(Integer top_p) {
        this.top_p = top_p;
    }

    public Integer getFrequency_penalty() {
        return frequency_penalty;
    }

    public void setFrequency_penalty(Integer frequency_penalty) {
        this.frequency_penalty = frequency_penalty;
    }

    public Integer getPresence_penalty() {
        return presence_penalty;
    }

    public void setPresence_penalty(Integer presence_penalty) {
        this.presence_penalty = presence_penalty;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("model", getModel());
        data.put("prompt", getPrompt());
        data.put("temperature", getTemperature());
        data.put("max_tokens", getMax_tokens());
        data.put("top_p", getTop_p());
        data.put("frequency_penalty", getFrequency_penalty());
        data.put("presence_penalty", getPresence_penalty());
        return data;
    }
}
