package com.example.skimanager;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class main_panel extends AppCompatActivity {
    Button btn_nowe_lekcje, btn_zalelelekcje, btn_ustawienia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel);
        btn_nowe_lekcje = findViewById(R.id.btn_noweLekcje);
        btn_zalelelekcje = findViewById(R.id.btn_zaleglelekcje);
        btn_ustawienia = findViewById(R.id.btn_ustawienia);
    }
}