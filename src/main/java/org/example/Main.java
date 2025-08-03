package org.example;

import org.example.util.CSVUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVUtil csvUtil = new CSVUtil("clientes.csv");

        List<String[]> dados = Arrays.asList(
                new String[]{"1,gustavo,gustavo@email.com,senhaSenha23,123344556,Rua teste"},
                new String[]{"2", "maria", "maria@email.com", "outraSenha", "987654321", "Rua exemplo"}
        );
    }
}