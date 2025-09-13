package org.example.view;

import org.example.client.ApiClient;
import org.example.util.ValidadorUtil;

import java.util.Map;

import static org.example.util.ValidadorUtil.capturarOpcaoMenuPrincipalComValidacao;

public class MenuCLI {
    private ApiClient apiClient;

    public MenuCLI() {
        this.apiClient = new ApiClient();
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("==== SISTEMA DE LOGIN ====");
            System.out.println("[1] - Login");
            System.out.println("[2] - Cadastro");
            System.out.println("[3] - Sair");

            int opcao = capturarOpcaoMenuPrincipalComValidacao();

            switch (opcao) {

                case 1:
                    Map respostaLogin = fluxoLogin();
                    System.out.println(respostaLogin.get("mensagem"));
                    break;
                case 2:
                    Map respostaCadastro = fluxoCadastro();
                    System.out.println(respostaCadastro.get("mensagem"));
                    break;
                case 3:
                    System.out.println("Obrigado por usar o sistema!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private Map fluxoLogin() {
        String email = ValidadorUtil.capturarEmailComValidacao();
        String senha = ValidadorUtil.capturarSenhaComValidacao();
        return apiClient.fazerLogin(email, senha);
    }

    private Map fluxoCadastro() {
        String nome = ValidadorUtil.capturarNomeComValidacao();
        String email = ValidadorUtil.capturarEmailComValidacao();
        String senha = ValidadorUtil.capturarSenhaComValidacao();
        String telefone = ValidadorUtil.capturarTelefoneComValidacao();
        String endereco = ValidadorUtil.capturarEndereco();
        return apiClient.cadastrarUsuario(nome, email, senha, telefone, endereco);
    }
}
