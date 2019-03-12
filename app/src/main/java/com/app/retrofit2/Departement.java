package com.app.retrofit2;

import com.google.gson.annotations.SerializedName;

public class Departement {

    @SerializedName("id")
    private Integer id;

    @SerializedName("libelle")
    private String libelle;

    @SerializedName("population")
    private int population;

    @SerializedName("nbreVille")
    private int nbreVille;

    public Departement() {
    }

    public Departement(Integer id, String libelle, int population, int nbreVille) {
        this.id = id;
        this.libelle = libelle;
        this.population = population;
        this.nbreVille = nbreVille;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getNbreVille() {
        return nbreVille;
    }

    public void setNbreVille(int nbreVille) {
        this.nbreVille = nbreVille;
    }
}
