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

    public CSVUtil(String arquivo) {
        this.caminhoCSV = Paths.get("src/main/resources/data/" + arquivo);
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
