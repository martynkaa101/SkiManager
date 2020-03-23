package com.example.skimanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button btn_login, btn_rejestracja;
    EditText txt_haslo_login, txt_email_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login=findViewById(R.id.btn_login);
        txt_email_login=findViewById(R.id._txt_email_login);
        txt_haslo_login=findViewById(R.id._txt_haslo_login);
        btn_rejestracja=findViewById(R.id.btn_rejestracja);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txt_email_login.getText().toString();
                String haslo=txt_haslo_login.getText().toString();
                String type="login";
                BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, email, haslo);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(backgroundTask.isResult1() == true) {
                        Intent intent = new Intent(login.this, MainPanel.class);
                        startActivity(intent);
                }

            }
        });

        btn_rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}