package com.example.repas2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.repas2.Models.Menu;

import java.util.ArrayList;

public class MenuListAdapter extends ArrayAdapter<Menu> {
    private Context mContext;
    int mRessource;

    /* Constructeur de MenuListAdapter */
    public MenuListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Menu> objects) {
        super(context, resource, objects);
        mContext = context;
        mRessource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Les valeurs d'un objet
        String name = getItem(position).getNom();
        String id = getItem(position).getId();
        int resImg = getItem(position).getResImg();
        Double prix = getItem(position).getPrix();
        int pos = getItem(position).getPosition();
        //Creer un objet de Menu
        Menu menu = new Menu(name, id, pos, resImg, prix);

        LayoutInflater inf = LayoutInflater.from(mContext);
        convertView = inf.inflate(mRessource, parent, false);
        // Le nom d'un item Menu
        TextView txtName = (TextView) convertView.findViewById(R.id.txtNom);
        txtName.setText(menu.getNom());
        //L'imageview pour afficher les items Menu
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);
        //img prends la propriete ResImg de l'objet menu
        img.setImageResource(menu.getResImg());
        //menuId prends l'id de l'objet menu est le stock dans un champs invisible
        TextView menuItemId = convertView.findViewById(R.id.textViewId);
        menuItemId.setText(menu.getId());

        return convertView;
    }

}
