package com.example.repas2.Models;

import java.util.ArrayList;
import java.util.List;

public class Salade extends Menu{
    public Salade(String nomSalade, String id,int position, int resImg, Double prix)
    {
        super();
        super.setNom(nomSalade);
        super.setId(id);
        super.setPosition(position);
        super.setResImg(resImg);
        super.setPrix(prix);
    }
}
