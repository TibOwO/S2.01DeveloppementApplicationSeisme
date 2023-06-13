package com.example.sae201;

import com.gluonhq.maps.MapLayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    @FXML
    private LineChart nbSeismeParAn;

    @FXML
    private NumberAxis nbSeismeParAnAxeX;

    @FXML
    private NumberAxis nbSeismeParAnAxeY;

    @FXML
    protected void handleCarte(){
        fenetre.setCenter(mapView);

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
        tableView.setItems(FXCollections.observableArrayList(tri));
        Statistiques.nbSeismesParAn(nbSeismeParAn, nbSeismeParAnAxeX, nbSeismeParAnAxeY, tri);
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