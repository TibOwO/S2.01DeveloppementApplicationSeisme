package com.example.sae201;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Seisme {

    private StringProperty id = new SimpleStringProperty();
    private StringProperty date;
    private StringProperty heure;
    private StringProperty nom;
    private StringProperty regionEpicentrale;
    private StringProperty choc;
    private StringProperty xRGF93;
    private StringProperty yRGF93;
    private StringProperty latitude;
    private StringProperty longitude;
    private StringProperty intensiteEpicentrale;
    private StringProperty qualiteIntensiteEpicentrale;

    public Seisme(String id, String date, String heure, String nom, String regionEpicentrale, String choc, String xRGF93, String yRGF93, String latitude, String longitude, String intensiteEpicentrale, String qualiteIntensiteEpicentrale) {
        this.id = new SimpleStringProperty(id);
        this.date = new SimpleStringProperty(date);
        this.heure = new SimpleStringProperty(heure);
        this.nom = new SimpleStringProperty(nom);
        this.regionEpicentrale = new SimpleStringProperty(regionEpicentrale);
        this.choc = new SimpleStringProperty(choc);
        this.xRGF93 = new SimpleStringProperty(xRGF93);
        this.yRGF93 = new SimpleStringProperty(yRGF93);
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.intensiteEpicentrale = new SimpleStringProperty(intensiteEpicentrale);
        this.qualiteIntensiteEpicentrale = new SimpleStringProperty(qualiteIntensiteEpicentrale);
    }

    public Seisme() {
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getHeure() {
        return heure.get();
    }

    public StringProperty heureProperty() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure.set(heure);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getRegionEpicentrale() {
        return regionEpicentrale.get();
    }

    public StringProperty regionEpicentraleProperty() {
        return regionEpicentrale;
    }

    public void setRegionEpicentrale(String regionEpicentrale) {
        this.regionEpicentrale.set(regionEpicentrale);
    }

    public String getChoc() {
        return choc.get();
    }

    public StringProperty chocProperty() {
        return choc;
    }

    public void setChoc(String choc) {
        this.choc.set(choc);
    }

    public String getxRGF93() {
        return xRGF93.get();
    }

    public StringProperty xRGF93Property() {
        return xRGF93;
    }

    public void setxRGF93(String xRGF93) {
        this.xRGF93.set(xRGF93);
    }

    public String getyRGF93() {
        return yRGF93.get();
    }

    public StringProperty yRGF93Property() {
        return yRGF93;
    }

    public void setyRGF93(String yRGF93) {
        this.yRGF93.set(yRGF93);
    }

    public String getLatitude() {
        return latitude.get();
    }

    public StringProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }

    public String getLongitude() {
        return longitude.get();
    }

    public StringProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }

    public String getIntensiteEpicentrale() {
        return intensiteEpicentrale.get();
    }

    public StringProperty intensiteEpicentraleProperty() {
        return intensiteEpicentrale;
    }

    public void setIntensiteEpicentrale(String intensiteEpicentrale) {
        this.intensiteEpicentrale.set(intensiteEpicentrale);
    }

    public String getQualiteIntensiteEpicentrale() {
        return qualiteIntensiteEpicentrale.get();
    }

    public StringProperty qualiteIntensiteEpicentraleProperty() {
        return qualiteIntensiteEpicentrale;
    }

    public void setQualiteIntensiteEpicentrale(String qualiteIntensiteEpicentrale) {
        this.qualiteIntensiteEpicentrale.set(qualiteIntensiteEpicentrale);
    }

    @Override
    public String toString() {
        return "Seisme{" +
                "id=" + id.get() +
                ", date=" + date.get() +
                ", heure=" + heure.get() +
                ", nom=" + nom.get() +
                ", regionEpicentrale=" + regionEpicentrale.get() +
                ", choc=" + choc.get() +
                ", xRGF93=" + xRGF93.get() +
                ", yRGF93=" + yRGF93.get() +
                ", latitude=" + latitude.get() +
                ", longitude=" + longitude.get() +
                ", intensiteEpicentrale=" + intensiteEpicentrale.get() +
                ", qualiteIntensiteEpicentrale=" + qualiteIntensiteEpicentrale.get() +
                '}';
    }
}
