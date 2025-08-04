package org.example.controller;

import org.example.view.ClienteView;

import java.util.Scanner;

public class GerenciadorMenu {
    private GerenciadorAutenticacao gerenciadorAut;
    private ClienteView clienteView;

    public GerenciadorMenu() {
        this.gerenciadorAut = new GerenciadorAutenticacao();
        this.clienteView = new ClienteView(this.gerenciadorAut);
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public GerenciadorAutenticacao getGerenciadorAut() {
        return gerenciadorAut;
    }

    public boolean validarOpcaoMenuPrincipal(int opcao) {
        if (opcao < 1 || opcao > 3) return false;

        return true;
    }

    public boolean validarOpcaoFluxoLogin(int opcao) {
        if (opcao < 1 || opcao > 2) return false;

        return true;
    }

    public int capturarOpcaoMenuPrincipalComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            String opcaoStr = scanner.nextLine().trim();

            try {
                int opcao = Integer.parseInt(opcaoStr);

                if (validarOpcaoMenuPrincipal(opcao)) {
                    return opcao;
                } else {
                    System.out.println("ERRO: Digite a opção 1, 2 ou 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números para selecionar uma opção.");
            }
        }
    }

    public int capturarOpcaoFluxoLoginComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Deseja se cadastrar? [1] - Sim / [2] - Não");
            String opcaoStr = scanner.nextLine().trim();

            try {
                int opcao = Integer.parseInt(opcaoStr);

                if (validarOpcaoFluxoLogin(opcao)) {
                    return opcao;
                } else {
                    System.out.println("ERRO: Digite a opção 1 para SIM ou 2 para NAO.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números para selecionar uma opção.");
            }
        }
    }
}
