package com.example.repas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView loginName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        loginName = findViewById(R.id.textViewAdmin);
        String text = getIntent().getStringExtra("loginName");
        loginName.setText("Vous etes connecté en tant que "+text);

        GridView gridview = findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        //L'evenement de click sur un des categories dans le GridView
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                // On passe la position de l'image
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}