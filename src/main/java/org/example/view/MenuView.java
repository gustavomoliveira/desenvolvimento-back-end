package org.example.view;

import org.example.controller.GerenciadorMenu;
import org.example.model.Cliente;

import java.io.IOException;

public class MenuView {
    private GerenciadorMenu gerenciadorMenu;

    public MenuView() {
        this.gerenciadorMenu = new GerenciadorMenu();
    }

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("==== SISTEMA DE LOGIN ====");
            System.out.println("[1] - Realizar Login");
            System.out.println("[2] - Se cadastrar");
            System.out.println("[3] - Sair");
            int opcao = gerenciadorMenu.capturarOpcaoMenuPrincipalComValidacao();

            switch(opcao) {
                case 1:
                    executarFluxoLogin();
                    break;
                case 2:
                    executarFluxoCadastro();
                    break;
                case 3:
                    System.out.println("Obrigado por usar o sistema!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public void executarFluxoLogin() {
        try {
            System.out.println("==== LOGIN ====");

            String email = gerenciadorMenu.getClienteView().capturarEmailComValidacao();

            if (!gerenciadorMenu.getGerenciadorAut().emailJaExiste(email)) {
                System.out.println("ERRO: E-mail não encontrado!");
                int opcao = gerenciadorMenu.capturarOpcaoFluxoLoginComValidacao();

                if (opcao == 1) {
                    executarFluxoCadastro();
                }

                return;
            }

            String senha = gerenciadorMenu.getClienteView().capturarSenhaComValidacao();

            Cliente clienteLogado = gerenciadorMenu.getGerenciadorAut().realizarLogin(email, senha);

            if (clienteLogado != null) {
                gerenciadorMenu.getClienteView().exibirMensagemLoginSucesso(clienteLogado);
            } else {
                gerenciadorMenu.getClienteView().exibirMensagemLoginFalhou();
            }
        } catch (IOException e) {
            System.out.println("ERRO: Nnao foi possível acessar os dados: " + e.getMessage());
        }
    }

    public void executarFluxoCadastro() {
        try {
            String[] dadosCliente = gerenciadorMenu.getClienteView().capturarDadosCompletosParaCadastro();

            boolean sucesso = gerenciadorMenu.getGerenciadorAut().cadastrarNovoCliente(
                    dadosCliente[0],
                    dadosCliente[1],
                    dadosCliente[2],
                    dadosCliente[3],
                    dadosCliente[4]
            );

            if (sucesso) {
                gerenciadorMenu.getClienteView().exibirMensagemCadastroSucesso();
            } else {
                gerenciadorMenu.getClienteView().exibirMensagemCadastroFalhou("Dados inválidos ou e-mail já existente!");
            }
        } catch (IOException e) {
            System.out.println("ERRO: Não foi possível salvar os dados: " + e.getMessage());
        }
    }
}
