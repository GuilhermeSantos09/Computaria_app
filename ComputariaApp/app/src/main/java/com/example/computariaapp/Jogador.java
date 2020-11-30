package com.example.computariaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import static android.content.Intent.ACTION_VIEW;

public class Jogador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);
    }
    public void bt_joga2(View view){
        Intent intent = new Intent(this, Jogador2.class);
        startActivity(intent);
    }
}