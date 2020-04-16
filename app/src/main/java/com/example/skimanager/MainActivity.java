package com.example.skimanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button _btnReg, _btnLogin;
    EditText _txtImie, _txtNazwisko, _txtUrodziny, _txtTelefon, _txtEmail, _txtHaslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(Base64.encodeToString("test".getBytes(), Base64.DEFAULT));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnLogin=(Button)findViewById(R.id.login_btn);
        _btnReg=(Button)findViewById(R.id.rejestracja_btn);
        _txtImie=(EditText)findViewById(R.id.txt_imie);
        _txtNazwisko=(EditText)findViewById(R.id.txt_nazwisko);
        _txtUrodziny=(EditText)findViewById(R.id.txt_urodziny);
        _txtTelefon=(EditText)findViewById(R.id.txt_telefon);
        _txtEmail=(EditText)findViewById(R.id.txt_email);
        _txtHaslo=(EditText)findViewById(R.id.txt_haslo);
        _btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie=_txtImie.getText().toString();
                String nazwisko=_txtNazwisko.getText().toString();
                String urodziny=_txtUrodziny.getText().toString();
                String telefon=_txtTelefon.getText().toString();
                String email=_txtEmail.getText().toString();
                String haslo = Base64.encodeToString(_txtHaslo.getText().toString().getBytes(), Base64.DEFAULT);
                String type="reg";
                BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, imie, nazwisko, urodziny, telefon, email, haslo);

            }
        });
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });

    }

}
