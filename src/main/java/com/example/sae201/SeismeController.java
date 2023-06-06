package com.example.sae201;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;


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
        ListView<CSVRecord> csvFileListView = new ListView<>();
        ListView<TableColumn> tableColumnListView = new ListView<>();
        for ( CSVRecord title : csvParser.getRecords()){
            csvFileListView.getItems().add(title);
        }

        for (String title : csvFileListView.getItems().get(0)){
            TableColumn newTableColumn = new TableColumn(title);
            newTableColumn.setCellValueFactory(new PropertyValueFactory(title));
            tableColumnListView.getItems().add(newTableColumn);
        }
//
        tableau.getColumns().addAll(tableColumnListView.getItems());
        tableau.getItems().add(csvFileListView.getItems().get(0).toList());


    }


}