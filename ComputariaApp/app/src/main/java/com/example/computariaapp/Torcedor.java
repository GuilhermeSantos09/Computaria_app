package com.example.computariaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Torcedor extends AppCompatActivity {

    private static int REQUEST_CODE = 100;
    ImageView wallpaper;
    Button SaveImg;
    OutputStream outputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torcedor);
        SaveImg = findViewById(R.id.saveimgbtn);
        wallpaper = findViewById(R.id.wallpaper);
        SaveImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(Torcedor.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

                    saveImage();

                }else {


                    askPermission();

                }

            }
        });
    }

    private void askPermission() {

        ActivityCompat.requestPermissions(Torcedor.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {

        if (requestCode == REQUEST_CODE)
        {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){


                saveImage();

            }else {


                Toast.makeText(Torcedor.this,"Please provide the required permissions",Toast.LENGTH_SHORT).show();

            }

        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void saveImage() {

        File dir = new File(Environment.getExternalStorageDirectory(),"SaveImage");

        if (!dir.exists()){

            dir.mkdir();

        }

        BitmapDrawable drawable = (BitmapDrawable) wallpaper.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        File file = new File(dir,System.currentTimeMillis()+".jpg");
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        Toast.makeText(Torcedor.this,"Successfuly Saved",Toast.LENGTH_SHORT).show();

        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void bt_torce2(View view) {
        Intent intent = new Intent(this, torcedor2.class);
        startActivity(intent);
    }
}