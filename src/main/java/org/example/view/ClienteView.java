package org.example.view;

import org.example.controller.GerenciadorAutenticacao;
import org.example.model.Cliente;

import java.util.Scanner;

public class ClienteView {
    private GerenciadorAutenticacao gerenciadorAut;

    public ClienteView(GerenciadorAutenticacao gerenciadorAut) {
        this.gerenciadorAut = gerenciadorAut;
    }

    public String capturarEmailComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu e-mail:");
            String email = scanner.nextLine().trim();

            if (gerenciadorAut.validarEmail(email)) {
                return email;
            } else {
                System.out.println("ERRO: E-mail inválido! Use o formato: exemplo@dominio.com(.br).");
            }
        }
    }

    public String capturarSenhaComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();

            if (gerenciadorAut.validarSenha(senha)) {
                return senha;
            } else {
                System.out.println("ERRO: Senha inválida!");
                System.out.println("A senha deve conter:");
                System.out.println("1 - Mínimo de 6 cvaracteres.");
                System.out.println("2 - Pelo menos 1 letra maiúscula.");
                System.out.println("3 - Pelo menos 1 números.");
            }
        }
    }

    public String capturarNomeComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine().trim();

            if (gerenciadorAut.validarNome(nome)) {
                return nome;
            } else {
                System.out.println("ERRO: Nome não pode estar vazio!");
            }
        }
    }

    public String capturarTelefoneComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu telefone:");
            String telefone = scanner.nextLine();

            if (gerenciadorAut.validarTelefone(telefone)) {
                return telefone;
            } else {
                System.out.println("ERRO: Telefone inválido! Use o formato (99) 99999 9999.");
            }
        }
    }

    public String capturarEndereco() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu endereço:");
        return scanner.nextLine();
    }

    public void exibirMensagemLoginSucesso(Cliente cliente) {
        System.out.println("Login realizado com sucesso!");
        System.out.println("Bem-vindo(a), " + cliente.getNome() + "!");
        System.out.println();
    }

    public void exibirMensagemLoginFalhou() {
        System.out.println("ERRO: E-mail ou senha incorretos!");
        System.out.println("Tente novamente ou cadastre-se.");
        System.out.println();
    }

    public void exibirMensagemCadastroSucesso() {
        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("Agora você pode fazer login.");
        System.out.println();
    }

    public void exibirMensagemCadastroFalhou(String motivo) {
        System.out.println("ERRO: Falha no cadastro: " + motivo);
        System.out.println("Tente novamente.");
        System.out.println();
    }

    public void exibirMensagemEmailJaExiste() {
        System.out.println("ERRO: Este email já está cadastrado!");
        System.out.println("Tente fazer login ou use outro email.");
        System.out.println();
    }

    public String[] capturarDadosCompletosParaCadastro() {
        System.out.println("==== CADASTRO DE NOVO CLIENTE ====");
        String nome = capturarNomeComValidacao();
        String email = capturarEmailComValidacao();
        String senha = capturarSenhaComValidacao();
        String telefone = capturarTelefoneComValidacao();
        String endereco = capturarEndereco();

        return new String[]{nome, email, senha, telefone, endereco};
    }

}
