package service;

import com.google.gson.Gson;
import modelo.ExchangeResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    private final Gson gson = new Gson();
    private  final HttpClient httpClient = HttpClient.newHttpClient();

    public ExchangeResponse obterDados(String endereco) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return gson.fromJson(response.body(), ExchangeResponse.class);
    }
}
