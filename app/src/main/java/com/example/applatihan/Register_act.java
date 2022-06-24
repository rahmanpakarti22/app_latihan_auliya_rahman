package com.example.applatihan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register_act extends AppCompatActivity
{

    RadioGroup radioGroup;//deklarasi radiogroup
    RadioButton gender_1, gender_2;//deklarasi radiobutton
    //Edittext widget
    EditText nama_lengkap, email, umur, pekerjaan;
    //Textview widget
    TextView gender, city;
    //Button widget
    Button submit;
    //AutoCompleteTextView
    AutoCompleteTextView filled_exposed;

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //deklarasi edittext widget
        nama_lengkap = findViewById(R.id.nama_lengkapET);
        email        = findViewById(R.id.emailET);
        umur         = findViewById(R.id.umurET);
        pekerjaan    = findViewById(R.id.pekerjaanET);
        //deklarasi textview widget
        gender       = findViewById(R.id.textview_selected);
        city         = findViewById(R.id.textview_selected_city);
        //deklarasi button widget
        submit       = findViewById(R.id.btn_submit);
        //deklarasi autoCompleteTextView widget
        filled_exposed   = findViewById(R.id.filled_exposed);
        //radiogroup
        radioGroup       = findViewById(R.id.radiogroup);
        //radioButton
        gender_1         = findViewById(R.id.gender_1);
        gender_2         = findViewById(R.id.gender_2);

        gender.setVisibility(View.GONE);
        city.setVisibility(View.GONE);

        //RadioButton
        radioGroup.setOnCheckedChangeListener((radioGroup, i) ->
        {
            switch (i)
            {
                case R.id.gender_1:
                    gender.setText(""+gender_1.getText());
                    break;
                case R.id.gender_2:
                    gender.setText(""+gender_2.getText());
                    break;
            }
        });

        //Array untuk kota
        String[] type = new String[]{"Ambon", "Balikpapan", "Banda Aceh", "Bandar Lampung", "Bandung", "Banjar", "Batam", "Batu", "Surabaya", "Bekasi",
                "Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan", "Jakarta Timur", "Jakarta Utara"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.drop_down_item, type
        );

        filled_exposed.setAdapter(adapter);
        filled_exposed.setOnItemClickListener((adapterView, view, i, l) -> filled_exposed.getText().toString());

        submit.setOnClickListener(view -> Validasi_data_regristrasi());
    }

    private void Validasi_data_regristrasi()
    {
        //Validasi form regristrasi
        String nama_valid = nama_lengkap.getText().toString();
        String email_valid = email.getText().toString();
        String umur_valid = umur.getText().toString();
        String pekerjaan_valid = pekerjaan.getText().toString();
        String city_valid = filled_exposed.getText().toString();
        String gender_valid = gender.getText().toString();

        if (TextUtils.isEmpty(nama_valid))
        {
            Toast.makeText(this, "Nama Lengkap Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(email_valid))
        {
            Toast.makeText(this, "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(umur_valid))
        {
            Toast.makeText(this, "Umur Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(pekerjaan_valid))
        {
            Toast.makeText(this, "Pekerjaan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(city_valid))
        {
            Toast.makeText(this, "Kota Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(gender_valid))
        {
            Toast.makeText(this, "Gender Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else
        {
            submit();
        }
    }

    private void submit()
    {
        Intent gotouserprofile = new Intent(Register_act.this, User_profile_act.class);
        gotouserprofile.putExtra("data_nama", nama_lengkap.getText().toString());
        gotouserprofile.putExtra("data_email", email.getText().toString());
        gotouserprofile.putExtra("data_umur", umur.getText().toString());
        gotouserprofile.putExtra("data_pekerjaan", pekerjaan.getText().toString());
        gotouserprofile.putExtra("data_kota", city.getText().toString());
        gotouserprofile.putExtra("data_gender", gender.getText().toString());
        startActivity(gotouserprofile);
        finish();
    }
}