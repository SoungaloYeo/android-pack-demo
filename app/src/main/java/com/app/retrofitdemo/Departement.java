package com.app.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Departement {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("libelle")
    @Expose
    private String libelle;

    @SerializedName("population")
    @Expose
    private int population;

    @SerializedName("nbreVille")
    @Expose
    private int nbreVille;

    public Departement() {
    }

    public Departement(Long id, String libelle, int population, int nbreVille) {
        this.id = id;
        this.libelle = libelle;
        this.population = population;
        this.nbreVille = nbreVille;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", population=" + population +
                ", nbreVille=" + nbreVille +
                '}';
    }
}
