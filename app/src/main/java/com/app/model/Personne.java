package com.app.model;

import java.io.Serializable;

public class Personne implements Serializable {

    private String code;
    private String nom;
    private String prenom;
    private String  commune;

    public Personne(String code, String nom, String prenom, String commune) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.commune = commune;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", commune='" + commune + '\'' +
                '}';
    }
}
