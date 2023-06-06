package com.example.sae201;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Seisme {

    private SimpleStringProperty id;
    private SimpleStringProperty date;
    private SimpleStringProperty heure;
    private SimpleStringProperty nom;
    private SimpleStringProperty regionEpicentrale;
    private SimpleStringProperty choc;
    private SimpleStringProperty xRGF93;
    private SimpleStringProperty yRGF93;
    private SimpleStringProperty latitude;
    private SimpleStringProperty longitude;
    private SimpleStringProperty intensiteEpicentrale;
    private SimpleStringProperty qualiteIntensiteEpicentrale;

    public Seisme(SimpleStringProperty id, SimpleStringProperty date, SimpleStringProperty heure, SimpleStringProperty nom, SimpleStringProperty regionEpicentrale, SimpleStringProperty choc, SimpleStringProperty xRGF93, SimpleStringProperty yRGF93, SimpleStringProperty latitude, SimpleStringProperty longitude, SimpleStringProperty intensiteEpicentrale, SimpleStringProperty qualiteIntensiteEpicentrale) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.nom = nom;
        this.regionEpicentrale = regionEpicentrale;
        this.choc = choc;
        this.xRGF93 = xRGF93;
        this.yRGF93 = yRGF93;
        this.latitude = latitude;
        this.longitude = longitude;
        this.intensiteEpicentrale = intensiteEpicentrale;
        this.qualiteIntensiteEpicentrale = qualiteIntensiteEpicentrale;
    }


    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getHeure() {
        return heure.get();
    }

    public SimpleStringProperty heureProperty() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure.set(heure);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getRegionEpicentrale() {
        return regionEpicentrale.get();
    }

    public SimpleStringProperty regionEpicentraleProperty() {
        return regionEpicentrale;
    }

    public void setRegionEpicentrale(String regionEpicentrale) {
        this.regionEpicentrale.set(regionEpicentrale);
    }

    public String getChoc() {
        return choc.get();
    }

    public SimpleStringProperty chocProperty() {
        return choc;
    }

    public void setChoc(String choc) {
        this.choc.set(choc);
    }

    public String getxRGF93() {
        return xRGF93.get();
    }

    public SimpleStringProperty xRGF93Property() {
        return xRGF93;
    }

    public void setxRGF93(String xRGF93) {
        this.xRGF93.set(xRGF93);
    }

    public String getyRGF93() {
        return yRGF93.get();
    }

    public SimpleStringProperty yRGF93Property() {
        return yRGF93;
    }

    public void setyRGF93(String yRGF93) {
        this.yRGF93.set(yRGF93);
    }

    public String getLatitude() {
        return latitude.get();
    }

    public SimpleStringProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }

    public String getLongitude() {
        return longitude.get();
    }

    public SimpleStringProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }

    public String getIntensiteEpicentrale() {
        return intensiteEpicentrale.get();
    }

    public SimpleStringProperty intensiteEpicentraleProperty() {
        return intensiteEpicentrale;
    }

    public void setIntensiteEpicentrale(String intensiteEpicentrale) {
        this.intensiteEpicentrale.set(intensiteEpicentrale);
    }

    public String getQualiteIntensiteEpicentrale() {
        return qualiteIntensiteEpicentrale.get();
    }

    public SimpleStringProperty qualiteIntensiteEpicentraleProperty() {
        return qualiteIntensiteEpicentrale;
    }

    public void setQualiteIntensiteEpicentrale(String qualiteIntensiteEpicentrale) {
        this.qualiteIntensiteEpicentrale.set(qualiteIntensiteEpicentrale);
    }
}
