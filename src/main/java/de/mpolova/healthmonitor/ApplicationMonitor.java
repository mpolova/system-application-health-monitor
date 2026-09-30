package de.mpolova.healthmonitor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;
import java.io.IOException;

public class ApplicationMonitor {

    private String url;

    public ApplicationMonitor(String url) {
        this.url = url;
    }

    public ApplicationMetrics anwendungPruefen() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(5))
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

    } catch (IOException e) {

        return new ApplicationMetrics(
                false,
                0,
                0
        );

    } catch (InterruptedException e) {

        Thread.currentThread().interrupt();

        return new ApplicationMetrics(
                false,
                0,
                0
        );
    }
    }
}