package com.example.repas2.Models;

import java.util.ArrayList;

/* Class Menu */
public class Menu {
    private String nom;
    private String id;
    private int position;
    private int resImg;
    private Double prix;

    /* Constructeurs */
    public Menu(String nom, String id,int position, int resImg, Double prix) {
        this.nom = nom;
        this.id = id;
        this.position = position;
        this.resImg = resImg;
        this.prix = prix;
    }

    public Menu() { }

    /* Getters & Setters */
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getResImg() { return resImg;}
    public void setResImg(int resImg) { this.resImg = resImg; }

    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix; }

    public int getPosition() { return position;}
    public void setPosition(int position) { this.position = position; }


    /* Methode getPrix qui retourne le prix d'un item Menu */
    public static Double getPrix(String id, ArrayList<Menu> listMenu){
        for (Menu m : listMenu) {
            if(m.getId().equals(id)){
                return m.getPrix();
            }
        }
        return null;
    }

}
