package com.example.computariaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bt_joga(View view){
        Intent intent = new Intent(this, Jogador.class);
        startActivity(intent);
    }
    public void bt_torce(View view){
        Intent intent = new Intent(this, Torcedor.class);
        startActivity(intent);
    }
}