package org.example.model;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    public Cliente(Long id, String nome, String email, String senha, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
}
