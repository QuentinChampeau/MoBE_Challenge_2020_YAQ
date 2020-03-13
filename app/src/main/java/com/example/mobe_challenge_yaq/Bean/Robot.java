package com.example.mobe_challenge_yaq.Bean;

import java.util.List;
/*
    bean robot
 */
public class Robot {

    private String nom;

    private  int pdv;

    private Position positionDepart;

    private List<Position> deplacement;

    private int mancheGagne;

    public Robot(String nom, Position positionDepart, List<Position> deplacement, int mancheGagne) {
        this.nom = nom;
        this.pdv = 2;
        this.positionDepart = positionDepart;
        this.deplacement = deplacement;
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

    public Position getPositionDepart() {
        return positionDepart;
    }

    public void setPositionDepart(Position positionDepart) {
        this.positionDepart = positionDepart;
    }

    public List<Position> getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(List<Position> deplacement) {
        this.deplacement = deplacement;
    }

    public int getMancheGagne() {
        return mancheGagne;
    }

    public void setMancheGagne(int mancheGagne) {
        this.mancheGagne = mancheGagne;
    }
}
