package com.example.sae201;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSeisme {
    private List<Seisme> seismeList;

    //Les constructeurs
    public ListSeisme() {
        this.seismeList = new ArrayList<>();
    }

    public ListSeisme(List<Seisme> uneListe){
        this.seismeList = uneListe;
    }




    //Les fonctions de recherche
    public ListSeisme filtrerParIntensiteEpicentrale(String aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList()));
        return filteredList;
    }

    public ListSeisme filtrerParId(int aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.idProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList()));
        return filteredList;
    }

    public ListSeisme filtrerParDate(String aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.dateProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList()));
        return filteredList;
    }


    //Les getters et setters
    public List<Seisme> getSeismeList() {
        return seismeList;
    }

    public void setSeismeList(List<Seisme> seismeList) {
        this.seismeList = seismeList;
    }
}
