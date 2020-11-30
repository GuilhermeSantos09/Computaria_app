package com.example.computariaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import static android.content.Intent.ACTION_VIEW;

public class torcedor2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torcedor2);
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
    public void btnEndereco(View view) {
        String url = "https://www.google.com/maps/place/ETEC+Professor+Basilides+de+Godoy./@-23.5209127,-46.7308168,17z/data=!3m1!4b1!4m5!3m4!1s0x94cef8c1d371ec31:0x671c9325c275132e!8m2!3d-23.5209127!4d-46.7286281";
        Intent intent = new Intent(ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}