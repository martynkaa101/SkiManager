package com.example.skimanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainPanel extends AppCompatActivity {
    Button btn_nowe_lekcje, btn_zalelelekcje, btn_ustawienia, btn_wyloguj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel2);
        btn_nowe_lekcje = findViewById(R.id.btn_noweLekcje);
        btn_zalelelekcje = findViewById(R.id.btn_zaleglelekcje);
        btn_ustawienia = findViewById(R.id.btn_ustawienia);
        btn_wyloguj = findViewById(R.id.btn_wyloguj);
        btn_wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, login.class);
                startActivity(intent);
            }
        });
        btn_nowe_lekcje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPanel.this, InstructorChoice.class);
                startActivity(intent);
            }
        });
    }
}