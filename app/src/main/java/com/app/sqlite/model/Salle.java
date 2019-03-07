package com.app.sqlite.model;

public class Salle {

    private Long id;
    private String designation;
    private int nbrePlace;

    public Salle(Long id, String designation, int nbrePlace) {
        this.id = id;
        this.designation = designation;
        this.nbrePlace = nbrePlace;
    }

    public Salle(String designation, int nbrePlace) {
        this.designation = designation;
        this.nbrePlace = nbrePlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(int nbrePlace) {
        this.nbrePlace = nbrePlace;
    }
}
