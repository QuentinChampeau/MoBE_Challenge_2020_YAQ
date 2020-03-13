package com.example.mobe_challenge_yaq.Bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.INotificationSideChannel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    bean robot
 */
public class Robot implements Parcelable {

    private String nom;

    private Bitmap bitmap;

    private int pdv;

    private Integer positionDepart;

    private List<Integer> deplacement;

    private int mancheGagne;

    public Robot(String nom, Bitmap bitmap, Integer positionDepart, int mancheGagne) {
        this.nom = nom;
        this.bitmap = bitmap;
        this.pdv = 2;
        this.positionDepart = positionDepart;
        this.deplacement = new ArrayList<>();
        this.deplacement.add(positionDepart);
        this.mancheGagne = mancheGagne;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
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

    public void addDeplacement(int index) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
