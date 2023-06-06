package com.example.sae201;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;



public class SeismeController {

    private static final String SAMPLE_CSV_FILE_PATH = "/amuhome/d22004772/R2.02 dev ihm/INtellij/S2.01DeveloppementApplicationSeisme/src/main/resources/com/example/sae201/SisFrance_seismes.csv";
    Reader reader;





    @FXML
    private TableView tableau;

    public void initialize() {
        CSVParser csvParser;
        try {
            reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tableau.getColumns().addAll(csvParser.getRecords().get(0));
        tableau.getItems().addAll(csvParser.getRecords());

    }


}