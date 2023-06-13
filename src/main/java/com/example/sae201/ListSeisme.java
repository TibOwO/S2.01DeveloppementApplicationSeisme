package com.example.sae201;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sert a eviter d'avoir trop de code dans la classe controlleur. Cela recupere la liste des donnees du CSV
 * et applique les filtres.
 */
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

    /**
     * Sert a rechercher par intensite epicentrale
     * @param aGarder string de ce que l'on veut chercher
     * @return liste filtree avec uniquement ce qui nous interesse
     */
    public ListSeisme filtrerParIntensiteEpicentrale(String aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.intensiteEpicentraleProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList()));
        return filteredList;
    }

    /**
     * Sert a rechercher par identifiant
     * @param aGarder string de ce que l'on veut chercher
     * @return liste filtree avec uniquement ce qui nous interesse
     */
    public ListSeisme filtrerParId(int aGarder) {
        ListSeisme filteredList = new ListSeisme(this.getSeismeList().stream()
                .filter(entry -> entry.idProperty().getValue().toString().startsWith(String.valueOf(aGarder)))
                .collect(Collectors.toList()));
        return filteredList;
    }

    /**
     * Sert a rechercher par date
     * @param aGarder string de ce que l'on veut chercher
     * @return liste filtree avec uniquement ce qui nous interesse
     */
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
