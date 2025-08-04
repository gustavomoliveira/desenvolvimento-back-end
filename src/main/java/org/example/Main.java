package org.example;

import org.example.view.MenuView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuView executarMenu = new MenuView();

        executarMenu.exibirMenuPrincipal();
    }
}