package com.example.apiMagic.apiMagic.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@Component
public class ConsomeApi {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String obterDadosComStream(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}

