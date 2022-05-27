package com.example.repas2.Models;

public class Dessert extends Menu{
    public Dessert(String nomDessert, String id,int position, int resImg, Double prix)
    {
        super();
        super.setNom(nomDessert);
        super.setId(id);
        super.setPosition(position);
        super.setResImg(resImg);
        super.setPrix(prix);
    }
}