package org.example.api;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.controller.GerenciadorAutenticacaoController;
import org.example.model.Cliente;

import java.io.IOException;
import java.util.Map;

public class AuthController {
    private static GerenciadorAutenticacaoController gerenciadorAuth = new GerenciadorAutenticacaoController();

    public static void registrarRotas(Javalin app) {
        app.post("/cadastrar", AuthController::processarCadastro);
        app.post("/login", AuthController::processarLogin);
    }

    private static void processarCadastro(Context context) {
        try {
            Cliente novoCliente = context.bodyAsClass(Cliente.class);

            boolean sucesso = gerenciadorAuth.cadastrarNovoCliente(
                    novoCliente.getNome(),
                    novoCliente.getEmail(),
                    novoCliente.getSenha(),
                    novoCliente.getTelefone(),
                    novoCliente.getEndereco()
            );

            if (sucesso) {
                context.status(201).json(Map.of("sucesso", true, "mensagem", "Cliente cadastrado com sucesso!"));
            } else {
                context.status(400).json(Map.of("sucesso", false, "mensagem", "Erro ao cadastrar"));
            }
        } catch (IOException e) {
            context.status(500).json(Map.of("sucesso", false, "mensagem", "Erro interno: " + e.getMessage()));
        }
    }

    private static void processarLogin(Context context) {
        try {
            Cliente dadosLogin = context.bodyAsClass(Cliente.class);

            Cliente clienteLogado = gerenciadorAuth.realizarLogin(
                    dadosLogin.getEmail(),
                    dadosLogin.getSenha()
            );

            if (clienteLogado != null) {
                context.status(200).json(Map.of("sucesso", true, "mensagem", "Login realizado com sucesso!"));
            } else {
                context.status(401).json(Map.of("sucesso", false, "mensagem", "Email ou senha incorretos"));
            }

        } catch (IOException e) {
            context.status(500).json(Map.of("sucesso", false, "mensagem", "Erro interno: " + e.getMessage()));
        }
    }
}
