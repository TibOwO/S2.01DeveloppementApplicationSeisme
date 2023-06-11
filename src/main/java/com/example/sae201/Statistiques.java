package com.example.sae201;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;

import static com.example.sae201.OuvertureJava2.lSeismes;

public class Statistiques {

    public static void nbSeismesParAn(LineChart linechart, NumberAxis xAxis, NumberAxis yAxis){
        // Tri de la liste en fonction de la date
        lSeismes.sort(Comparator.comparing(Seisme::getDate));
        // Creation des axes du linechart (Axe X = annees, axe Y = nb de seisme)
        xAxis = new NumberAxis(lSeismes.get(0).getDate().getYear() -10, lSeismes.get(lSeismes.size()-1).getDate().getYear() +10, 10);
        xAxis.setLabel("Annees");
        yAxis = new NumberAxis();
        yAxis.setLabel("Nombre de seisme");

        XYChart.Series series = new XYChart.Series();
        series.setName("Nombre de seisme par an");

        LocalDate datePrecedente = lSeismes.get(0).getDate();
        int cpt = 0;
        for (int i =1; i<lSeismes.size(); ++i){         // Compter le nombre de seisme par an
            if (lSeismes.get(i).dateProperty().get().getYear() == datePrecedente.getYear()){
                cpt ++;
            }
            else {
                series.getData().add(new XYChart.Data(datePrecedente.getYear(), cpt));      //Ajouter les donnees dans un graphique
                cpt = 0;
            }
            datePrecedente = lSeismes.get(i).getDate();
        }
        linechart.getData().add(series);



    }
}
