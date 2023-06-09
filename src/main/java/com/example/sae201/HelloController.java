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

import java.util.List;
import java.util.stream.Collectors;
import  static com.example.sae201.OuvertureJava2.lesSeismes;
import java.util.List;
import java.util.stream.Collectors;

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
        ListSeisme tri = lesSeismes.filtrerParId(id.getText());
        tri = tri.filtrerParIntensiteEpicentrale(intensiteEpicentrale.getText());
        tri = tri.filtrerParDate(date.getText());
        tableView.setItems(FXCollections.observableArrayList(tri.getSeismeList()));
        System.out.println(tri.getSeismeList());
    }


}