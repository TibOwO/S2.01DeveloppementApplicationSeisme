package com.example.sae201;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OuvertureJava2 {

    static ArrayList<Seisme> lSeismes = new ArrayList<>();
    private static String sampleCsvFilePath = "/amuhome/r22011072/r202/S2.01DeveloppementApplicationSeisme/src/main/resources/com/example/sae201/SisFrance_seismes_20230604151458.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(sampleCsvFilePath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            Seisme aAjouter = null;
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String id = csvRecord.get(0);
                String date = csvRecord.get(1);
                String heure = csvRecord.get(2);
                String nom = csvRecord.get(3);
                String regionEpicentrale = csvRecord.get(4);
                String choc = csvRecord.get(5);
                String xRGF93 = csvRecord.get(6);
                String yRGF93 = csvRecord.get(7);
                String latitude = csvRecord.get(8);
                String longitude = csvRecord.get(9);
                String intensiteEpicentrale = csvRecord.get(10);
                String qualiteIntensiteEpicentrale = csvRecord.get(11);
                aAjouter.setId(id);
                aAjouter.setDate(date);
                aAjouter.setHeure(heure);
                aAjouter.setNom(nom);
                aAjouter.setRegionEpicentrale(regionEpicentrale);
                aAjouter.setChoc(choc);
                aAjouter.setxRGF93(xRGF93);
                aAjouter.setyRGF93(yRGF93);
                aAjouter.setLatitude(latitude);
                aAjouter.setLongitude(longitude);
                aAjouter.setIntensiteEpicentrale(intensiteEpicentrale);
                aAjouter.setQualiteIntensiteEpicentrale(qualiteIntensiteEpicentrale);

                lSeismes.add(aAjouter);



                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Id : " + id);
                System.out.println("Date : " + date);
                System.out.println("Heure : " + heure);
                System.out.println("Nom : " + nom);
                System.out.println("Région : " + regionEpicentrale);
                System.out.println("Choc : " + choc);
                System.out.println("X RGF93 : " + xRGF93);
                System.out.println("Y RGF93 : " + yRGF93);
                System.out.println("Latitude : " + latitude);
                System.out.println("Longitude : " + longitude);
                System.out.println("intensite epicentrale : " + intensiteEpicentrale);
                System.out.println("Qualité intensite epicentrale : " + qualiteIntensiteEpicentrale);
                System.out.println("---------------\n\n");
            }
        }

    }
}