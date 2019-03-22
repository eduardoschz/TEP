package com.example.aplicacion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtUsuario, txtContra;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContra = findViewById(R.id.txtContra);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((txtUsuario.getText() != null || txtContra.getText() != null) &&
                        ((txtUsuario.getText().toString().equals("edu")) && txtContra.getText().toString().equals("edu97"))){
                    Intent i1 = new Intent(getBaseContext(), Bienvenido.class);
                    i1.putExtra("user", txtUsuario.getText().toString());
                    //i1.putExtra("pass", txtContra.getText().toString());
                    startActivity(i1);
                    //finish();
                } else {
                    Intent i2 = new Intent(getBaseContext(), Verificar.class);
                    startActivity(i2);
                    finish();

                }

            }
        });

    }
}
