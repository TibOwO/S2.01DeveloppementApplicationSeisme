package com.example.sae201;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
}