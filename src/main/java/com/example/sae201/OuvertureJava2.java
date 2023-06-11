package com.example.sae201;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OuvertureJava2 {

    static List<Seisme> lSeismes = new ArrayList<>();
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/resources/SisFrance_seismes_20230605113030.csv";
    public static void main() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(
                        SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withSkipHeaderRecord());

        ) {
            Seisme aAjouter;
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                int id = Integer.parseInt(csvRecord.get(0));
                String dateString = csvRecord.get(1);
                Date date = formatDate(dateString);
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
                System.out.println("Processed following date : " + date);
                aAjouter = new Seisme(id, date, heure, nom, regionEpicentrale, choc, xRGF93, yRGF93, latitude, longitude, intensiteEpicentrale, qualiteIntensiteEpicentrale);

                lSeismes.add(aAjouter);
            }
            /*
            for (Seisme e : lSeismes){
                System.out.println(e);
            }
             */

        }

    }
    public static Date formatDate(String dateFromString)  {
        Date date = new Date();
        List<String> sepAnneeMoisJour = new ArrayList<String>(Arrays.asList(dateFromString.split("/")));
        System.out.println(sepAnneeMoisJour);
        switch (sepAnneeMoisJour.size()) {
            case 3: // Si il y a l annee, le mois et le jour
                if (dateFromString.length() == 9) {
                    dateFromString = "0" + dateFromString;
                }
                try{
                    date = new SimpleDateFormat("yyyy/MM/dd").parse(dateFromString);
                }
                catch (ParseException e){
                    throw new RuntimeException(e);
                }
                break;
            case 2: // S'il y a l annee et le mois
                if (dateFromString.length() == 6) {
                    dateFromString = "0" + dateFromString;
                }
                try{
                    date = new SimpleDateFormat("yyyy/MM").parse(dateFromString);
                }
                catch (ParseException e){
                    throw new RuntimeException(e);
                }
                break;
            case 1: // S'il n y a que l annee
                if (dateFromString.length() == 4) {
                    dateFromString = "0" + dateFromString;
                }
                try{
                    dateFromString = dateFromString.replace("/", "");
                    date = new SimpleDateFormat("yyyy").parse(dateFromString);
                }
                catch (ParseException e){
                    throw new RuntimeException(e);
                }
                break;
        }
        return date;
    }
}