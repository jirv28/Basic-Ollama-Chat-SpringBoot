package com.ollamaspring.ollamaspring;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaService {

    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";
    private final RestTemplate restTemplate = new RestTemplate();

    public String askOllama(String prompt) {
        // Build request body
        Map<String, Object> request = new HashMap<>();
        request.put("model", "gemma2:2b"); // change if you want another model
        request.put("prompt", prompt);
        request.put("stream", false); // 👈 wait for full response

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        // Call Ollama API
        ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, entity, Map.class);

        // Extract response text
        Map body = response.getBody();
        if (body != null && body.containsKey("response")) {
            return (String) body.get("response");
        }
        return "No response from Ollama.";
    }
}
