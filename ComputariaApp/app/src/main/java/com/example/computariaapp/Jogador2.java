package com.example.computariaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

public class Jogador2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador2);

        final EditText esporte = (EditText) findViewById(R.id.editEsporte);

        Button gravar = (Button) findViewById(R.id.btnGravar);
        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("preferencias",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();

                ed.putString("esporte", esporte.getText().toString());

                ed.apply();
                Toast.makeText(getBaseContext(), "Gravado com sucesso",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button limpar = (Button) findViewById(R.id.btnLimpar);
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("preferencias",
                        Context.MODE_PRIVATE);
                esporte.setText(prefs.getString("esporte", "não tem"));
            }
        });
    }

    public void bt_intent1(View view) {
        String url = "https://www.instagram.com/computaria_ds/";
        Intent intent = new Intent(ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void bt_intent2(View view) {
        String url = "https://www.youtube.com/channel/UC9s6THpakX7o4dbqnpVu4gg";
        Intent intent = new Intent(ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}


