package com.example.repas2.Models;

public class Repas extends Menu{
    public Repas(String nomRepas, String id,int position, int resImg, Double prix)
    {
        super();
        super.setNom(nomRepas);
        super.setId(id);
        super.setPosition(position);
        super.setResImg(resImg);
        super.setPrix(prix);
    }
}