package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.sae201.OuvertureJava2.lSeismes;

public class HelloController {

    @FXML
    private TextField id;
    @FXML
    private TextField intensiteEpicentrale;

    @FXML
    private TextField date;

    @FXML
    protected void handleRechercher(){
        List<Seisme> tri = filtrerParId(lSeismes, id.getText());
        tri = filtrerParIntensiteEpicentrale(tri, intensiteEpicentrale.getText());
        tri = filtrerParDate(tri, date.getText());
        System.out.println(tri);
    }

    public static List<Seisme> filtrerParIntensiteEpicentrale(List<Seisme> liste, String aGarder){
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParId(List<Seisme> liste, String aGarder){
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.idProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }

    public static List<Seisme> filtrerParDate(List<Seisme> liste, String aGarder){
        List<Seisme> filteredList = liste.stream()
                .filter(entry -> entry.dateProperty().get().startsWith(aGarder))
                .collect(Collectors.toList());
        return filteredList;
    }
}