package com.example.sae201;

import javafx.scene.chart.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Statistiques {

    /**
     * Sert a faire un linechart du nombre de seisme par an
     * @param linechart LineChart defini dans le FXML
     * @param xAxis defini dans le FXML
     * @param donnees liste de Seisme qui peut etre triee
     */
    public static void nbSeismesParAn(LineChart linechart, NumberAxis xAxis, List<Seisme> donnees){
        linechart.getData().clear();
        // Tri de la liste en fonction de la date
        donnees.sort(Comparator.comparing(Seisme::getDate));
        // Creation des axes du linechart (Axe X = annees, axe Y = nb de seisme)
        xAxis.setLowerBound(donnees.get(0).getDate().getYear() -10);
        xAxis.setUpperBound(donnees.get(donnees.size()-1).getDate().getYear() +10);

        XYChart.Series series = new XYChart.Series();
        series.setName("Nombre de seisme par an");

        LocalDate datePrecedente = donnees.get(0).getDate();
        int cpt = 1;
        for (int i =1; i<donnees.size(); ++i){         // Compter le nombre de seisme par an
            if (donnees.get(i).dateProperty().get().getYear() == datePrecedente.getYear()){
                cpt ++;
            }
            else {
                series.getData().add(new XYChart.Data(datePrecedente.getYear(), cpt));      //Ajouter les donnees dans un graphique
                cpt = 1;
            }
            datePrecedente = donnees.get(i).getDate();
        }
        series.getData().add(new XYChart.Data(datePrecedente.getYear(), cpt));
        linechart.getData().add(series);
    }

    /**
     * Sert a faire un linechart du nombre de seisme par intensite epicentrale
     * @param linechart LineChart defini dans le FXML
     * @param xAxis defini dans le FXML
     * @param donnees liste de Seisme qui peut etre triee
     */
    public static void nbSeismesParIntensite(LineChart linechart, NumberAxis xAxis, List<Seisme> donnees){
        linechart.getData().clear();
        // Tri de la liste en fonction de la date
        donnees.sort(Comparator.comparing(Seisme::getIntensiteEpicentrale));
        // Creation des axes du linechart (Axe X = annees, axe Y = nb de seisme)
        xAxis.setLowerBound(donnees.get(0).getIntensiteEpicentrale() -1);
        xAxis.setUpperBound(donnees.get(donnees.size()-1).getIntensiteEpicentrale() +1);

        XYChart.Series series = new XYChart.Series();
        series.setName("Nombre de seisme par intensite");

        LocalDate datePrecedente = donnees.get(0).getDate();
        Float intensitePrecedente = donnees.get(0).getIntensiteEpicentrale();
        int cpt = 1;
        for (int i =1; i<donnees.size(); ++i){         // Compter le nombre de seisme par intensite
            if (donnees.get(i).getIntensiteEpicentrale() == intensitePrecedente){
                cpt ++;
            }
            else {
                series.getData().add(new XYChart.Data(intensitePrecedente, cpt));      //Ajouter les donnees dans un graphique
                cpt = 1;
            }
            intensitePrecedente = donnees.get(i).getIntensiteEpicentrale();
        }
        series.getData().add(new XYChart.Data(intensitePrecedente, cpt));
        linechart.getData().add(series);
    }

    /**
     * Sert a faire un linechart de la moyenne des intensites des seismes par an
     * @param linechart LineChart defini dans le FXML
     * @param xAxis defini dans le FXML
     * @param donnees liste de Seisme qui peut etre triee
     */
    public static void moyIntensiteParAn(LineChart linechart, NumberAxis xAxis, List<Seisme> donnees){
        linechart.getData().clear();
        // Tri de la liste en fonction de la date
        donnees.sort(Comparator.comparing(Seisme::getDate));
        // Creation des axes du linechart (Axe X = annees, axe Y = moyenne du nb de seisme)
        xAxis.setLowerBound(donnees.get(0).getDate().getYear() -10);
        xAxis.setUpperBound(donnees.get(donnees.size()-1).getDate().getYear() +10);

        XYChart.Series series = new XYChart.Series();
        series.setName("Moyenne de l'intensite des seismes par an");

        LocalDate datePrecedente = donnees.get(0).getDate();
        int cpt = 1;
        float somme = 0;
        for (int i =1; i<donnees.size(); ++i){         // Compter le nombre de seisme par an
            if (donnees.get(i).dateProperty().get().getYear() == datePrecedente.getYear()){
                cpt ++;
                somme += donnees.get(i).getIntensiteEpicentrale(); // Somme toutes les intensites d'une annee
            }
            else {
                series.getData().add(new XYChart.Data(datePrecedente.getYear(), somme/cpt));      //Ajouter les donnees dans un graphique
                cpt = 1;
                somme = 0;
            }
            datePrecedente = donnees.get(i).getDate();
        }
        series.getData().add(new XYChart.Data(datePrecedente.getYear(), somme/cpt));
        linechart.getData().add(series);
    }

    /**
     * Sert a faire un linechart de la moyenne des intensites des seismes par region. Il y a un bug a l'affichage de l'axe x,
     * il faut re cliquer sur rechercher ou bien faire la recherche sans etre dans l'onglet statistique.
     * @param linechart LineChart defini dans le FXML
     * @param xAxis defini dans le FXML
     * @param donnees liste de Seisme qui peut etre triee
     */
    public static void moyIntensiteParRegion(LineChart linechart, CategoryAxis xAxis, List<Seisme> donnees){
        linechart.getData().clear();
        // Tri de la liste en fonction de la date
        donnees.sort(Comparator.comparing(Seisme::getRegionEpicentrale));

        XYChart.Series series = new XYChart.Series();
        series.setName("Moyenne de l'intensite des seismes par region");

        String regionPrecedente = donnees.get(0).getRegionEpicentrale();
        int cpt = 1;
        float somme = 0;
        for (int i =1; i<donnees.size(); ++i){         // On parcourt les donnees
            if (donnees.get(i).getRegionEpicentrale().equals(regionPrecedente) ){
                cpt ++;
                somme += donnees.get(i).getIntensiteEpicentrale(); // Somme toutes les intensites d'une region
            }
            else {series.getData().add(new XYChart.Data(regionPrecedente, somme/cpt));      //Ajouter les donnees dans un graphique
                cpt = 1;
                somme = 0;
            }
            regionPrecedente = donnees.get(i).getRegionEpicentrale();
        }
        series.getData().add(new XYChart.Data(regionPrecedente, somme/cpt));        // On ajoute le dernier
        linechart.getData().add(series);
    }

    /**
     * Sert a creer un diagramme circulaire qui montre comment sont répartis les seismes en fonction des regions.
     * @param pieChart PieChart défini dans le FXML
     * @param donnees liste de Seisme qui peut etre triee
     */
    public static void classementRegionsSysmiques(PieChart pieChart, List<Seisme> donnees){
        pieChart.getData().clear();
        // Tri de la liste en fonction de la date
        donnees.sort(Comparator.comparing(Seisme::getRegionEpicentrale));

        String regionPrecedente = donnees.get(0).getRegionEpicentrale();
        int cpt = 1;
        for (int i =1; i<donnees.size(); ++i){         // On parcourt les donnees
            if (donnees.get(i).getRegionEpicentrale().equals(regionPrecedente) ){
                cpt ++;
            }
            else {
                PieChart.Data nbSeismeParRegion = new PieChart.Data(regionPrecedente, cpt);
                pieChart.getData().add(nbSeismeParRegion);
                cpt = 1;
            }
            regionPrecedente = donnees.get(i).getRegionEpicentrale();
        }
        PieChart.Data nbSeismeParRegion = new PieChart.Data(regionPrecedente, cpt);
        pieChart.getData().add(nbSeismeParRegion);
    }
}
