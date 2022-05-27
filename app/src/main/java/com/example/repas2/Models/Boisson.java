package com.example.repas2.Models;

public class Boisson extends Menu{
    public Boisson(String nomBoisson, String id,int position, int resImg, Double prix)
    {
        super();
        super.setNom(nomBoisson);
        super.setId(id);
        super.setPosition(position);
        super.setResImg(resImg);
        super.setPrix(prix);
    }
}