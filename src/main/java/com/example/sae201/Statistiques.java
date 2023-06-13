package com.example.sae201;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;

import static com.example.sae201.OuvertureJava2.lSeismes;

public class Statistiques {

    public static void nbSeismesParAn(LineChart linechart, NumberAxis xAxis, NumberAxis yAxis, List<Seisme> donnees){
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
        linechart.getData().add(series);
    }

    public static void nbSeismesParIntensite(LineChart linechart, NumberAxis xAxis, NumberAxis yAxis, List<Seisme> donnees){
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
        linechart.getData().add(series);
    }
    public static void moyIntensiteParAn(LineChart linechart, NumberAxis xAxis, NumberAxis yAxis, List<Seisme> donnees){
        linechart.getData().clear();
        // Tri de la liste en fonction de la date
        donnees.sort(Comparator.comparing(Seisme::getDate));
        // Creation des axes du linechart (Axe X = annees, axe Y = moyenne du nb de seisme)
        xAxis.setLowerBound(donnees.get(0).getDate().getYear() -10);
        xAxis.setUpperBound(donnees.get(donnees.size()-1).getDate().getYear() +10);

        XYChart.Series series = new XYChart.Series();
        series.setName("Nombre de seisme par an");

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
        linechart.getData().add(series);
    }
}
