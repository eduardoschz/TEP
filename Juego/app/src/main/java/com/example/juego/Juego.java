package com.example.juego;

import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView txtNombre;
    Button btnAzul, btnAma, btnRojo, btnVerde;
    final int VERDE = 1, ROJO = 2, AMARILLO = 3, AZUL = 4;
    ArrayList<Integer> seq = new ArrayList<>();
    List<Integer> jugador = new ArrayList<>();



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        txtNombre = findViewById(R.id.txtNombre);

        btnAma = findViewById(R.id.btnAma);
        btnAma.setBackgroundColor(Color.YELLOW);

        btnAzul = findViewById(R.id.btnAzu);
        btnAzul.setBackgroundColor(Color.BLUE);


        btnVerde = findViewById(R.id.btnVerde);
        btnVerde.setBackgroundColor(Color.GREEN);

        btnRojo = findViewById(R.id.btnRojo);
        btnRojo.setBackgroundColor(Color.RED);

        Bundle datos = getIntent().getExtras();
        txtNombre.setText(datos.getString("name"));


        btnVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugador.add(VERDE);
                sonido(VERDE);
            }


        });

        btnRojo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                jugador.add(ROJO);
                sonido(ROJO);
                return false;
            }
        });

        btnAma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugador.add(AMARILLO);
                sonido(AMARILLO);
            }
        });

        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugador.add(AZUL);
                sonido(AZUL);
            }
        });


        iniciar();
    }

    private void aleatorio() {
        seq.add(new Random().nextInt(4) + 1);
    }

    private void sonido(int s) {
        MediaPlayer m;

        switch (s) {
            case VERDE:
                btnVerde.setBackgroundColor(Color.argb(255,0,255,0));
                m = MediaPlayer.create(getBaseContext(), R.raw.s1);
                m.start();
                break;
            case ROJO:
                btnRojo.setBackgroundColor(Color.rgb(255,50,10));
                m = MediaPlayer.create(getBaseContext(), R.raw.s2);
                m.start();
                break;
            case AMARILLO:
                btnAma.setBackgroundColor(Color.YELLOW);
                m = MediaPlayer.create(getBaseContext(), R.raw.s3);
                m.start();
                break;
            case AZUL:
                btnAzul.setBackgroundColor(Color.BLUE);
                m = MediaPlayer.create(getBaseContext(), R.raw.s4);
                m.start();
                break;
            default:
                btnAma.setBackgroundColor(Color.YELLOW);

                btnAzul.setBackgroundColor(Color.BLUE);

                btnVerde.setBackgroundColor(Color.GREEN);

                btnRojo.setBackgroundColor(Color.RED);



        }

    }

    private void iniciar() {
        aleatorio();

        new CountDownTimer(seq.size() * 1000, 500) {

            int cont = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                sonido(seq.get(cont));
                cont++;
            }

            @Override
            public void onFinish() {
                cont = 0;
                Toast.makeText(getBaseContext(), "Tu turno", Toast.LENGTH_SHORT).show();
            }
        }.start();

    }

    private boolean juego(){
        int cont = 0;
        if (btnAzul.isPressed() ||btnAma.isPressed() ||btnVerde.isPressed() ||btnRojo.isPressed()){
            boolean s = seq.get(cont) == jugador.get(cont);


            return true;
        }
        else{
            return false;
        }
    }
}
