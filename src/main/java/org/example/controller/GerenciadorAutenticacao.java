package org.example.controller;

import org.example.model.Cliente;
import org.example.util.CSVUtil;

import java.io.IOException;
import java.util.List;

public class GerenciadorAutenticacao {
    private CSVUtil csv;

    public GerenciadorAutenticacao() {
        this.csv = new CSVUtil();
    }

    public Long gerarProximoId() throws IOException {
        List<String[]> dadosCSV = csv.lerCSV();

        if (dadosCSV.isEmpty()) return 1L;

        Long maiorId = dadosCSV.stream()
                .mapToLong(linha -> Long.parseLong(linha[0]))
                .max()
                .orElse(0L);

        return maiorId + 1;
    }

    public boolean emailJaExiste(String email) throws IOException {
        List<String[]> dadosCSV = csv.lerCSV();

        boolean emailValidado = dadosCSV.stream()
                .anyMatch(linha -> linha[2].equals(email));

        return emailValidado;
    }

    public boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;

        String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

        return email.matches(regex);
    }

    public boolean validarSenha(String senha) {
        String regexMaiuscula = ".*[A-Z].*";
        String regexUmNumero = ".*[0-9].*";

        if (senha == null || senha.trim().isEmpty()) return false;

        if (senha.length() < 6) return false;

        if (!senha.matches(regexMaiuscula)) return false;

        if (!senha.matches(regexUmNumero)) return false;

        return true;
    }

    public boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;

        return true;
    }

    public boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return false;
        }

        String regex = "^[0-9]{2}[0-9]{5}[0-9]{4}$";
        return telefone.matches(regex);
    }

    public boolean cadastrarNovoCliente(String nome, String email, String senha, String telefone, String endereco) throws IOException {
        if (!validarNome(nome)) return false;

        if (!validarEmail(email)) return false;

        if (emailJaExiste(email)) return false;

        if (!validarSenha(senha)) return false;

        Long novoId = gerarProximoId();

        String[] dadosCliente = {
                novoId.toString(),
                nome,
                email,
                senha,
                telefone,
                endereco
        };

        csv.escreverLinhaCSV(dadosCliente);

        return true;
    }

    public Cliente realizarLogin(String email, String senha) throws IOException {
        List<String[]> dadosCSV = csv.lerCSV();

        for (String[] linha : dadosCSV) {
            String emailCSV = linha[2];
            String senhaCSV = linha[3];

            if (emailCSV.equals(email) && senhaCSV.equals(senha)) {

                Cliente cliente = new Cliente(
                        Long.parseLong(linha[0]),
                        linha[1],
                        linha[2],
                        linha[3],
                        linha[4],
                        linha[5]
                );

                return cliente;
            }
        }

        return null;
    }

}
