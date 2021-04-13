package org.jonesun.demoapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author jone.sun
 * @date 2020-12-28 16:42
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8102/oauth/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=password&client_id=client-app&client_secret=123456&username=admin&password=123456"))
                .build();

        CompletableFuture<String> result = HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> {
                    try {
                        return objectMapper.readValue(body, LoginResponseResult.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return new LoginResponseResult();
                    }
                })
                .thenCompose(loginResponseResult ->
                        HttpClient.newHttpClient().sendAsync(HttpRequest.newBuilder()
                                .uri(URI.create("http://localhost:8102/jonesun-user-api/api/currentUser"))
                                .header("Authorization", loginResponseResult.getData().getTokenHead() + loginResponseResult.getData().getToken())
                                .build(), HttpResponse.BodyHandlers.ofString())
                                .thenApply(HttpResponse::body));
        System.out.println(result.get());

    }

}
