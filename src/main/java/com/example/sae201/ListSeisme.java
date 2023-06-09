package com.example.sae201;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSeisme {
    private List<Seisme> seismeList;

    public ListSeisme() {
        this.seismeList = new ArrayList<>();
    }

    public ListSeisme(List<Seisme> uneListe){
        this.seismeList = uneListe;
    }

    public ListSeisme filtrerParIntensiteEpicentrale(String aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().get().startsWith(aGarder))
                .collect(Collectors.toList()));
        return filteredList;
    }

    public ListSeisme filtrerParId(String aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.idProperty().get().startsWith(aGarder))
                .collect(Collectors.toList()));
        return filteredList;
    }

    public ListSeisme filtrerParDate(String aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.dateProperty().get().startsWith(aGarder))
                .collect(Collectors.toList()));
        return filteredList;
    }

    public List<Seisme> getSeismeList() {
        return seismeList;
    }

    public void setSeismeList(List<Seisme> seismeList) {
        this.seismeList = seismeList;
    }
}
