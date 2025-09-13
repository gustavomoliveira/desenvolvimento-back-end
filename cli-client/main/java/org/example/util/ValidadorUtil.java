package org.example.util;

import java.util.Scanner;

public class ValidadorUtil {

    public static boolean validarOpcaoMenuPrincipal(int opcao) {
        if (opcao < 1 || opcao > 3) return false;

        return true;
    }

    public static int capturarOpcaoMenuPrincipalComValidacao() {
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

    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;

        String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

        return email.matches(regex);
    }

    public static boolean validarSenha(String senha) {
        String regexMaiuscula = ".*[A-Z].*";
        String regexUmNumero = ".*[0-9].*";

        if (senha == null || senha.trim().isEmpty()) return false;

        if (senha.length() < 6) return false;

        if (!senha.matches(regexMaiuscula)) return false;

        if (!senha.matches(regexUmNumero)) return false;

        return true;
    }

    public static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;

        return true;
    }

    public static boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return false;
        }

        String regex = "^[0-9]{2}[0-9]{5}[0-9]{4}$";
        return telefone.matches(regex);
    }

    public static String capturarEmailComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu e-mail:");
            String email = scanner.nextLine().trim();

            if (validarEmail(email)) {
                return email;
            } else {
                System.out.println("ERRO: E-mail inválido! Use o formato: exemplo@dominio.com(.br).");
            }
        }
    }

    public static String capturarSenhaComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();

            if (validarSenha(senha)) {
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

    public static String capturarNomeComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine().trim();

            if (validarNome(nome)) {
                return nome;
            } else {
                System.out.println("ERRO: Nome não pode estar vazio!");
            }
        }
    }

    public static String capturarTelefoneComValidacao() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu telefone:");
            String telefone = scanner.nextLine();

            if (validarTelefone(telefone)) {
                return telefone;
            } else {
                System.out.println("ERRO: Telefone inválido! Use o formato (99) 99999 9999.");
            }
        }
    }

    public static String capturarEndereco() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu endereço:");
        return scanner.nextLine();
    }
}
