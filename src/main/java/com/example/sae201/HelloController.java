package com.example.sae201;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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
    private HBox carte;

    // Pour les graphiques
    @FXML
    private GridPane graphiques;

    @FXML
    private LineChart nbSeismeParAn;

    @FXML
    private NumberAxis nbSeismeParAnAxeX;

    @FXML
    private NumberAxis nbSeismeParAnAxeY;

    @FXML
    private LineChart nbSeismeParIntensite;

    @FXML
    private NumberAxis nbSeismeParIntensiteAxeX;

    @FXML
    private NumberAxis nbSeismeParIntensiteAxeY;

    @FXML
    private LineChart moyIntensiteParAn;

    @FXML
    private NumberAxis moyIntensiteParAnAxeX;

    @FXML
    private NumberAxis moyIntensiteParAnAxeY;

    @FXML
    private LineChart moyIntensiteParRegion;

    @FXML
    private CategoryAxis moyIntensiteParRegionAxeX;

    @FXML
    private NumberAxis moyIntensiteParRegionAxeY;

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
        if (id.getText() == "" || id.getText().isEmpty()){
            tri = lSeismes;
        }
        else{
            tri = filtrerParId(lSeismes, Integer.parseInt(id.getText()));
        }

        tri = filtrerParIntensiteEpicentrale(tri, intensiteEpicentrale.getText());
        tri = filtrerParDate(tri, date.getText());
        // Remplissage du tableau en fonction de la recherche
        tableView.setItems(FXCollections.observableArrayList(tri));
        // Creation des graphiques en fonction de la recherche
        Statistiques.nbSeismesParAn(nbSeismeParAn, nbSeismeParAnAxeX, tri);
        Statistiques.nbSeismesParIntensite(nbSeismeParIntensite, nbSeismeParIntensiteAxeX, tri);
        Statistiques.moyIntensiteParAn(moyIntensiteParAn, moyIntensiteParAnAxeX, tri);
        Statistiques.moyIntensiteParRegion(moyIntensiteParRegion, moyIntensiteParRegionAxeX, tri);
    }

    public static List<Seisme> filtrerParIntensiteEpicentrale(List<Seisme> liste, String aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParId(List<Seisme> liste, int aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.idProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParDate(List<Seisme> liste, String aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.dateProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList());
        return filteredList;
    }
}