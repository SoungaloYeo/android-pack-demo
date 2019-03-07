package com.app.activeAndroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Ville")
public class Ville extends Model {

    @Column(name = "code", index = true)
    private String code;
    @Column(name = "designation")
    private String designation;
    @Column(name = "population")
    private int population;
    @Column(name = "dep")
    private String dep;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

//    public Ville() {
//    }
//
//    public Ville(String code, String designation, int population, String dep) {
//        this.code = code;
//        this.designation = designation;
//        this.population = population;
//        this.dep = dep;
//    }
}
