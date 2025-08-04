package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVUtil {
    private final Path caminhoCSV;

    public CSVUtil() {
        this.caminhoCSV = Paths.get("src/main/resources/data/clientes.csv");

        try {
            iniciarArquivoCSV();
        } catch (IOException e) {
            System.out.println("ERRO: Não foi possível iniciar o arquivo CSV: " + e.getMessage());;
        }
    }

    public void iniciarArquivoCSV() throws IOException {
        if (!Files.exists(this.caminhoCSV)) {

            Files.createDirectories(this.caminhoCSV.getParent());

            Files.createFile(this.caminhoCSV);

            System.out.println("Arquivo 'clientes.csv' criado em: " + this.caminhoCSV);
        } else {
            System.out.println("Arquivo clientes.csv localizado!");
        }
    }

    public List<String[]> lerCSV() throws IOException {
        List<String> linhas = Files.readAllLines(this.caminhoCSV);

        List<String[]> dadosCSV = linhas.stream()
                .map(linha -> linha.split(","))
                .collect(Collectors.toList());

        return dadosCSV;
    }

    public void escreverLinhaCSV(String[] novaLinha) throws IOException {
        String linha = String.join(",", novaLinha);

        Files.write(this.caminhoCSV,
                Arrays.asList(linha),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
}
