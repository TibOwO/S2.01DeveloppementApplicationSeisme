package com.example.sae201;

import com.gluonhq.maps.MapLayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    private MapView carte;


    @FXML
    private VBox carteContainer;

    @FXML
    private MapView mapView;

    @FXML
    private MapPoint mapPoint;

    //Initialisation de la map (appelée automatiquement)
    @FXML
    public void initialize() {

        //Initialisation de la MapView
        this.mapView = new MapView();

        /* Création du point avec latitude et longitude */
        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);

        /* Création et ajoute une couche à la carte */
        MapLayer mapLayer = new CustomCircleMarkerLayer(mapPoint);
        mapView.addLayer(mapLayer);

        /* Zoom de 5 */
        mapView.setZoom(6);

        /* Centre la carte sur le point */
        mapView.flyTo(0, mapPoint, 1);

        //on enleve le point qui centre la map sur la France
        mapView.removeLayer(mapLayer);

        /* Ajout de la map au container de la map (une Vbox) */
        carteContainer.getChildren().add(mapView);
    }

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
    protected void handleCarte() {
        fenetre.setCenter(mapView);

    }

    @FXML
    protected void handleStats() {
        fenetre.setCenter(graphiques);

    }

    @FXML
    protected void handleTableau() {
        fenetre.setCenter(tableView);
    }

    public static List<MapPoint> creationPointRecherche(List<Seisme> listRecherche) {
        List<MapPoint> listMapPoint = new ArrayList<>();
        for (Seisme seisme : listRecherche) {
            Double lat = seisme.getLatitude();
            Double lon = seisme.getLongitude();
            MapPoint mapPoint = new MapPoint(lat, lon);
            listMapPoint.add(mapPoint);
        }
        return listMapPoint;
    }

    @FXML
    protected void handleRechercher() {
        ListSeisme tri;
        if (id.getText() == "" || id.getText().isEmpty()) {
            tri = new ListSeisme(lesSeismes.getSeismeList());
        } else {
            tri = lesSeismes.filtrerParId(Integer.parseInt(id.getText()));
        }

        List<MapPoint> listMapPoint = creationPointRecherche(tri.getSeismeList());
        for (MapPoint mapPoint : listMapPoint) {
            MapLayer mapLayer = new CustomCircleMarkerLayer(mapPoint);
            mapView.addLayer(mapLayer);
        }

        tri = tri.filtrerParIntensiteEpicentrale(intensiteEpicentrale.getText());
        tri = tri.filtrerParDate(date.getText());
        tableView.setItems(FXCollections.observableArrayList(tri.getSeismeList()));
        // Remplissage du tableau en fonction de la recherche
        tableView.setItems(FXCollections.observableArrayList(tri.getSeismeList()));
        // Creation des graphiques en fonction de la recherche
        Statistiques.nbSeismesParAn(nbSeismeParAn, nbSeismeParAnAxeX, tri.getSeismeList());
        Statistiques.nbSeismesParIntensite(nbSeismeParIntensite, nbSeismeParIntensiteAxeX, tri.getSeismeList());
        Statistiques.moyIntensiteParAn(moyIntensiteParAn, moyIntensiteParAnAxeX, tri.getSeismeList());
        Statistiques.moyIntensiteParRegion(moyIntensiteParRegion, moyIntensiteParRegionAxeX, tri.getSeismeList());
    }

    @FXML
    public void handleCsv(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Utiliser le fichier sélectionné / vider l'ancienne liste
            System.out.println("Fichier sélectionné : " + selectedFile.getAbsolutePath());
            lesSeismes.getSeismeList().clear();
            // Appeler la méthode pour lire le fichier CSV et effectuer le traitement nécessaire
            try {
                OuvertureJava2.main(selectedFile.getAbsolutePath());

                // Mettre à jour l'affichage dans le tableau
                tableView.setItems(FXCollections.observableArrayList(lesSeismes.getSeismeList()));

                // Effectuer d'autres actions si nécessaire
            } catch (IOException e) {
                e.printStackTrace();
                // Gérer les exceptions liées à la lecture du fichier CSV
            }
        }
    }


}