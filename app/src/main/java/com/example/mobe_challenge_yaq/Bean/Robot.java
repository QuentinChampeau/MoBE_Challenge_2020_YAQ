package com.example.mobe_challenge_yaq.Bean;

import java.util.ArrayList;
import java.util.List;
/*
    bean robot
 */
public class Robot {

    private String nom;

    private  int pdv;

    private Integer positionDepart;

    private List<Integer> deplacement;

    private int mancheGagne;

    public Robot(String nom, Integer positionDepart, int mancheGagne) {
        this.nom = nom;
        this.pdv = 2;
        this.deplacement = new ArrayList<>();
        this.positionDepart = positionDepart;
        this.deplacement.add(positionDepart);
        this.mancheGagne = mancheGagne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public void addDeplacement(int index){
        this.deplacement.add(index);
    }

    public int getMancheGagne() {
        return mancheGagne;
    }

    public void setMancheGagne(int mancheGagne) {
        this.mancheGagne = mancheGagne;
    }

    public Integer getPositionDepart() {
        return positionDepart;
    }

    public void setPositionDepart(Integer positionDepart) {
        this.positionDepart = positionDepart;
    }

    public List<Integer> getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(List<Integer> deplacement) {
        this.deplacement = deplacement;
    }
}
