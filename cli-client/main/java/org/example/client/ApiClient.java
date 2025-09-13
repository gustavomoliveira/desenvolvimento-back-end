package org.example.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiClient {
    private String url = "http://localhost:8080";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Map pegarDados(String resource, String body) {
        try {
            URI uri = new URI(url + resource);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = tratarResponse(response);

            return objectMapper.readValue(jsonResponse, Map.class);

        } catch (URISyntaxException | InterruptedException | IOException e) {
            return Map.of("sucesso", false, "mensagem", "Erro na comunicação: " + e.getMessage());
        }
    }

    private String tratarResponse(HttpResponse<String> response) {
        int statusCode = response.statusCode();

        if (statusCode == 200 || statusCode == 201) {
            return response.body();
        }

        if (statusCode == 400 || statusCode == 401) {
            return response.body();
        }

        throw new RuntimeException("Erro na API. Status: " + statusCode + " - " + response.body());
    }

    private String criarJsonCadastro(String nome, String email, String senha, String telefone, String endereco) {
        return String.format("{\"nome\":\"%s\",\"email\":\"%s\",\"senha\":\"%s\",\"telefone\":\"%s\",\"endereco\":\"%s\"}",
                nome,email, senha, telefone, endereco);
    }

    private String criarJsonLogin(String email, String senha) {
        return String.format("{\"email\":\"%s\",\"senha\":\"%s\"}",
                email, senha);
    }

    public Map cadastrarUsuario(String nome, String email, String senha, String telefone, String endereco) {
        String json = criarJsonCadastro(nome, email, senha, telefone, endereco);
        return pegarDados("/cadastrar", json);
    }

    public Map fazerLogin(String email, String senha) {
        String json = criarJsonLogin(email, senha);
        return pegarDados("/login", json);
    }
}
