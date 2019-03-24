package com.example.juego;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNombre;
    Button btnInicia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtNombre);
        btnInicia = findViewById(R.id.btnInicia);


        btnInicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().equals("")) {
                    Intent juego = new Intent(getBaseContext(), Juego.class);
                    juego.putExtra("name", txtNombre.getText().toString());
                    startActivity(juego);
                    finish();
                } else {

                    Toast.makeText(getBaseContext(), "Ingresa tu nombre", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


}
