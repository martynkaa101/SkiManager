package com.example.skimanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainPanel extends AppCompatActivity {
    Button btn_newLessons, btn_pastLessons, btn_ustawienia, btn_wyloguj, btn_futureLessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel2);
        btn_newLessons = findViewById(R.id.btn_noweLekcje);
        btn_pastLessons = findViewById(R.id.btn_zaleglelekcje);
        btn_futureLessons = findViewById(R.id.btn_przyszlelekcje);
        btn_ustawienia = findViewById(R.id.btn_ustawienia);
        btn_wyloguj = findViewById(R.id.btn_wyloguj);
        btn_wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, Login.class);
                startActivity(intent);
            }
        });
        btn_newLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, InstructorChoice.class);
                startActivity(intent);
            }
        });
        btn_pastLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, RatingLessons.class);
                startActivity(intent);
            }
        });
        btn_futureLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, FutureLessons.class);
                startActivity(intent);
            }
        });
        btn_ustawienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, Settings.class);
                startActivity(intent);
            }
        });
    }
}