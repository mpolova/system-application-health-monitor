package de.mpolova.healthmonitor;

import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApplicationMonitor {
    private String url;

    public ApplicationMonitor(String url) {
        this.url = url;
    }

    public ApplicationMetrics anwendungPruefen() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            long startzeit = System.currentTimeMillis();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            long endzeit = System.currentTimeMillis();

            long antwortzeit = endzeit - startzeit;
            int httpStatuscode = response.statusCode();

            return new ApplicationMetrics(
                    true,
                    httpStatuscode,
                    antwortzeit
            );

        } catch (Exception e) {

            return new ApplicationMetrics(
                    false,
                    0,
                    0
            );
        }
    }