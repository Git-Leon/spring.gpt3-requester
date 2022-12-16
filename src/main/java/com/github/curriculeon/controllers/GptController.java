package com.github.curriculeon.controllers;

import com.github.curriculeon.models.GptNestedRequest;
import com.github.curriculeon.models.GptSimpleRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/gpt")
public class GptController {
    private RestTemplate restTemplate;

    public GptController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/nested-query")
    public ResponseEntity<String> nestedQuery(
            @RequestBody GptNestedRequest requestObject) {
        String token = requestObject.getToken();
        String prompt = requestObject.getPrompt();
        int n = requestObject.getN();
        GptSimpleRequest simpleRequest = new GptSimpleRequest(token, prompt);
        ResponseEntity<String> response = query(simpleRequest);
        String previousResponse = response.getBody();
        for (int i = 1; i < n; i++) {
            simpleRequest = new GptSimpleRequest(token, previousResponse);
            response = query(simpleRequest);
            previousResponse = response.getBody();
        }
        return response;
    }

    @PostMapping("/queries")
    public List<ResponseEntity<String>> queries(
            @RequestBody List<GptSimpleRequest> requestObjects) {
        List<ResponseEntity<String>> result = new ArrayList<>();
        for (GptSimpleRequest request : requestObjects) {
            result.add(query(request));
        }
        return result;
    }

    @PostMapping("/query")
    public ResponseEntity<String> query(
            @RequestBody GptSimpleRequest requestObject) {
        String url = "https://api.openai.com/v1/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + requestObject.getToken());

        Map<String, Object> data = new HashMap<>();
        data.put("model", "text-davinci-003");
        data.put("prompt", requestObject.getPrompt());
        data.put("temperature", 0.5);
        data.put("max_tokens", 2048);
        data.put("top_p", 1);
        data.put("frequency_penalty", 0);
        data.put("presence_penalty", 0);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response;
    }
}
