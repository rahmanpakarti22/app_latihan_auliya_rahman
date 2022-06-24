package com.example.applatihan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class User_profile_act extends AppCompatActivity
{

    //Edittext widget
    EditText nama_lengkap, email, umur, pekerjaan, city;
    //Textview widget
    TextView gender;
    //ImageButton widget
    ImageButton close;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        //deklarasi edittext widget
        nama_lengkap = findViewById(R.id.nama_lengkapET);
        email        = findViewById(R.id.emailET);
        umur         = findViewById(R.id.umurET);
        pekerjaan    = findViewById(R.id.pekerjaanET);
        city         = findViewById(R.id.kotaET);

        //deklarasi textview widget
        gender       = findViewById(R.id.textview_selected);
        //deklarasi imageButton widget
        close       = findViewById(R.id.close_btn);

        close.setOnClickListener(view -> {
            startActivity(new Intent(User_profile_act.this, Register_act.class));
            finish();
        });

        Intent intent = getIntent();
        nama_lengkap.setText(intent.getStringExtra("data_nama"));
        email.setText(intent.getStringExtra("data_email"));
        umur.setText(intent.getStringExtra("data_umur"));
        pekerjaan.setText(intent.getStringExtra("data_pekerjaan"));
        city.setText(intent.getStringExtra("data_kota"));
        gender.setText(intent.getStringExtra("data_gender"));
    }
}