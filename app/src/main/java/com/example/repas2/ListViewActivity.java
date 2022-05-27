package com.example.repas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.repas2.Models.Boisson;
import com.example.repas2.Models.Dessert;
import com.example.repas2.Models.Menu;
import com.example.repas2.Models.Repas;
import com.example.repas2.Models.Salade;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // On prend un des positions [0,1,2,3]
        // Chaque position correspond a un classe
        // 0: Dessert | 1: Boisson | 2:Repas | 3:Salade
        int position1 = getIntent().getExtras().getInt("id");


        //Instanciation des objects Dessert
        Dessert d1 = new Dessert("Caramel","ds1", position1, R.drawable.dessert_caramel, 40.00);
        Dessert d2 = new Dessert("Flan", "ds2",position1, R.drawable.dessert_flan, 25.00);
        Dessert d3 = new Dessert("Chocolat","ds3", position1, R.drawable.dessert_classic_chocolat, 35.00);
        Dessert d4 = new Dessert("Ice Cream", "ds4",position1, R.drawable.dessert_ice_cream, 20.00);
        //Instanciation des objects Boisson
        Boisson b1 = new Boisson("Coffee", "bs1",position1, R.drawable.boisson_coffee, 13.00);
        Boisson b2 = new Boisson("Jus Orange","bs2", position1, R.drawable.boisson_jus, 15.00);
        Boisson b3 = new Boisson("Fanta","bs3", position1, R.drawable.boisson_fanta, 10.00);
        Boisson b4 = new Boisson("Boisson Ice", "bs4",position1, R.drawable.boisson_ice, 13.00);
        //Instanciation des objects Repas
        Repas r1 = new Repas("Pizza", "rp1",position1, R.drawable.repas_pizza, 45.00);
        Repas r2 = new Repas("Oueff", "rp2",position1, R.drawable.repas_oeuf, 28.00);
        Repas r3 = new Repas("Tacos", "rp3", position1, R.drawable.repas_tacos, 30.00);
        Repas r4 = new Repas("Viande", "rp4", position1, R.drawable.repas_viande, 65.00);
        //Instanciation des objects Salade
        Salade s1 = new Salade("Salade 1","sl1",position1, R.drawable.salade1, 35.00);
        Salade s2 = new Salade("Salade 2", "sl2",position1, R.drawable.salade2, 38.00);
        Salade s3 = new Salade("Salade 3", "sl3",position1, R.drawable.salade3, 40.00);
        Salade s4 = new Salade("Salade 3", "sl4",position1, R.drawable.salade4, 28.00);

        //Arraylist list Menu pour stocker des objects qui herite de ce classe
        ArrayList<Menu> listMenu = new ArrayList<>();
        //ListView pour afficher tous les Categories d'un element
        ListView lv = findViewById(R.id.listViewCateg);
        //Un titre pour chaque Categorie
        TextView title = findViewById(R.id.textViewTitle);


        //On ajoute les objects dans menu par ses positions
        switch(position1) {
            //Si l'utilisateur a clické sur l'image de dessert qui
            // prend la position 0 on remplie la list de dessert
            case 0:
                title.setText("Desserts");
                listMenu.clear();
                listMenu.add(d1);
                listMenu.add(d2);
                listMenu.add(d3);
                listMenu.add(d4);
                break;
            //Le meme pour les autres
            case 1:
                title.setText("Boissons");
                listMenu.clear();
                listMenu.add(b1);
                listMenu.add(b2);
                listMenu.add(b3);
                listMenu.add(b4);
                break;
            case 2:
                title.setText("Repas");
                listMenu.clear();
                listMenu.add(r1);
                listMenu.add(r2);
                listMenu.add(r3);
                listMenu.add(r4);
                break;
            case 3:
                title.setText("Salades");
                listMenu.clear();
                listMenu.add(s1);
                listMenu.add(s2);
                listMenu.add(s3);
                listMenu.add(s4);
                break;
            default:
                // code block
        }

        //Instanciation d'un objet adapter de notre class MenuListAdapter
        MenuListAdapter adapter = new MenuListAdapter(this, R.layout.adapter_view_layout, listMenu);
        lv.setAdapter(adapter);

        //L'evenement de click sur un des lignes de listView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                TextView textPrix = findViewById(R.id.txtPrix);
                TextView textId = (TextView) v.findViewById(R.id.textViewId);
                TextView textNom = (TextView) v.findViewById(R.id.txtNom);
                //Aficher le Prix d'un element
                //Pour afficher le prix on appelle la methode statique Menu.getPrix qui retourne le prix d'un élément auquel on donne son id
                textPrix.setText("Le Prix de "+ textNom.getText().toString()+" est : "+ String.valueOf(Menu.getPrix(textId.getText().toString(), listMenu)+" DH"));
            }
        });

    }
}