package com.example.applatihan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

@SuppressLint("CustomSplashScreen")
public class Splashscreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler(Looper.getMainLooper()).postDelayed(() ->
        {
            startActivity(new Intent(Splashscreen.this, Register_act.class));
            finish();
        },400);
    }
}