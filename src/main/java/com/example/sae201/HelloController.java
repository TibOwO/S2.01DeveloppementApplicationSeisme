package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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
        List<Seisme> tri = filtrerParId(lSeismes, id.getText());
        tri = filtrerParIntensiteEpicentrale(tri, intensiteEpicentrale.getText());
        tri = filtrerParDate(tri, date.getText());
        tableView.setItems(FXCollections.observableArrayList(tri));
        System.out.println(tri);
    }

    public static List<Seisme> filtrerParIntensiteEpicentrale(List<Seisme> liste, String aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParId(List<Seisme> liste, String aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.idProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParDate(List<Seisme> liste, String aGarder) {
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.dateProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }
    @FXML
    public void handleCsv (ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Utiliser le fichier sélectionné / vider l'ancienne liste
            System.out.println("Fichier sélectionné : " + selectedFile.getAbsolutePath());
            lSeismes.clear();
            // Appeler la méthode pour lire le fichier CSV et effectuer le traitement nécessaire
            try {
                OuvertureJava2.main(selectedFile.getAbsolutePath());

                // Mettre à jour l'affichage dans le tableau
                tableView.setItems(FXCollections.observableArrayList(lSeismes));

                // Effectuer d'autres actions si nécessaire
            } catch (IOException e) {
                e.printStackTrace();
                // Gérer les exceptions liées à la lecture du fichier CSV
            }
        }
    }
}