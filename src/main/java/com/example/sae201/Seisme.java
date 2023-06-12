package com.example.sae201;

import javafx.beans.property.*;

import java.time.LocalDate;


public class Seisme {

    private IntegerProperty id;
    private SimpleObjectProperty<LocalDate> date;
    private StringProperty heure;
    private StringProperty nom;
    private StringProperty regionEpicentrale;
    private StringProperty choc;
    private DoubleProperty xRGF93;
    private DoubleProperty yRGF93;
    static DoubleProperty latitude;
    static DoubleProperty longitude;
    private FloatProperty intensiteEpicentrale;
    private StringProperty qualiteIntensiteEpicentrale;

    /*public Seisme(SimpleStringProperty id, SimpleStringProperty date, SimpleStringProperty heure, SimpleStringProperty nom, SimpleStringProperty regionEpicentrale, SimpleStringProperty choc, SimpleStringProperty xRGF93, SimpleStringProperty yRGF93, SimpleStringProperty latitude, SimpleStringProperty longitude, SimpleStringProperty intensiteEpicentrale, SimpleStringProperty qualiteIntensiteEpicentrale) {
        this.id = new SimpleStringProperty(id);
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
    }*/

    public Seisme(int id, LocalDate date, String heure, String nom, String regionEpicentrale, String choc, double xRGF93, double yRGF93, double latitude, double longitude, float intensiteEpicentrale, String qualiteIntensiteEpicentrale) {
        this.id = new SimpleIntegerProperty(id);
        this.date = new SimpleObjectProperty<LocalDate>(date);
        this.heure = new SimpleStringProperty(heure);
        this.nom = new SimpleStringProperty(nom);
        this.regionEpicentrale = new SimpleStringProperty(regionEpicentrale);
        this.choc = new SimpleStringProperty(choc);
        this.xRGF93 = new SimpleDoubleProperty(xRGF93);
        this.yRGF93 = new SimpleDoubleProperty(yRGF93);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.intensiteEpicentrale = new SimpleFloatProperty(intensiteEpicentrale);
        this.qualiteIntensiteEpicentrale = new SimpleStringProperty(qualiteIntensiteEpicentrale);
    }

    public Seisme() {
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public double getxRGF93() {
        return xRGF93.get();
    }

    public DoubleProperty xRGF93Property() {
        return xRGF93;
    }

    public void setxRGF93 (Double xRGF93) {
        this.xRGF93.set(xRGF93);
    }

    public double getyRGF93() {
        return yRGF93.get();
    }

    public DoubleProperty yRGF93Property() {
        return yRGF93;
    }

    public void setyRGF93(Double yRGF93) {
        this.yRGF93.set(yRGF93);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public DoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude.set(latitude);
    }

    public Double getLongitude() {
        return longitude.get();
    }

    public DoubleProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude.set(longitude);
    }

    public float getIntensiteEpicentrale() {
        return intensiteEpicentrale.get();
    }

    public FloatProperty intensiteEpicentraleProperty() {
        return intensiteEpicentrale;
    }

    public void setIntensiteEpicentrale(float intensiteEpicentrale) {
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