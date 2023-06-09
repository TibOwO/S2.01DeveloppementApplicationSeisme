package com.example.sae201;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static com.example.sae201.OuvertureJava2.lSeismes;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.sae201.OuvertureJava2.lSeismes;

public class HelloController {

    @FXML
    private BorderPane fenetre;
    @FXML
    private TableView<Seisme> tableView;

    @FXML
    private TextField id;
    @FXML
    private TextField intensiteEpicentrale;

    @FXML
    private TextField date;

    @FXML
    private GridPane graphiques;

    @FXML
    private HBox carte;

    @FXML
    protected void handleCarte(){
        fenetre.setCenter(carte);
    }

    @FXML
    protected void handleStats(){
        fenetre.setCenter(graphiques);
    }

    @FXML
    protected void handleTableau(){
        fenetre.setCenter(tableView);
    }
    @FXML
    protected void handleRechercher() {
        List<Seisme> tri;
        if (id.getText() == ""){
            tri = lSeismes;
        }
        else{
            tri = filtrerParId(lSeismes, Integer.parseInt(id.getText()));
        }

        tri = filtrerParIntensiteEpicentrale(tri, intensiteEpicentrale.getText());
        tri = filtrerParDate(tri, Date.from(Instant.parse(date.getText())));
        tableView.setItems(FXCollections.observableArrayList(tri));
        System.out.println(tri);
    }

    public static List<Seisme> filtrerParIntensiteEpicentrale(List<Seisme> liste, String aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParId(List<Seisme> liste, int aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.idProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParDate(List<Seisme> liste, Date aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.dateProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList());
        return filteredList;
    }
}