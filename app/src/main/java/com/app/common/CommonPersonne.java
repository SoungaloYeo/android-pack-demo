package com.app.common;

import com.app.model.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonPersonne {

    public static final String EXTRA_LISTE_PERS = "LISTE_PERS";

    private CommonPersonne() {
    }


    public static ArrayList<Personne> getList() {
        Personne p1 = new Personne("0001", "KONAN", "KAN KOUAKOU", "BOUAKÉ");
        Personne p2 = new Personne("002", "MAXIME", "KAN", "BOUAKÉ");
        Personne p3 = new Personne("003", "KOUASSI", "KAN BROU", "BOUAKÉ");
        Personne p4 = new Personne("004", "MOUMÉ", "KAN AKISSI", "BOUAKÉ");
        Personne p5 = new Personne("005", "AMOUIN", "KAN KRA", "BOUAKÉ");

        ArrayList<Personne> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        return list;
    }
}
