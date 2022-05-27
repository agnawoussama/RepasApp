package com.example.repas2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login = findViewById(R.id.editTextLogin);
        EditText pass = findViewById(R.id.editTextPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().equals("") && pass.getText().toString().equals("")){
                    Intent i = new Intent(MainActivity.this, NextActivity.class);
                    i.putExtra("loginName", String.valueOf(login.getText()));
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Login/Password Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}