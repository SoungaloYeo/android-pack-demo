package com.app.sqlite.model;

public class Etudiant {

    private Long id;
    private String nom;
    private String prenom;
    private String commune;
    private String filiere;

    public Etudiant() {
    }

    public Etudiant(Long id, String nom, String prenom, String commune, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.commune = commune;
        this.filiere = filiere;
    }
    public Etudiant(String nom, String prenom, String commune, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.commune = commune;
        this.filiere = filiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", commune='" + commune + '\'' +
                ", filiere='" + filiere + '\'' +
                '}';
    }
}
