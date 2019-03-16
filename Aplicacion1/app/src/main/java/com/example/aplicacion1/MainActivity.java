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

        txtUsuario = (TextView) findViewById(R.id.txtUsuario);
        txtContra = (TextView) findViewById(R.id.txtContra);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getBaseContext(), Bienvenido.class);
                Intent i2 = new Intent(getBaseContext(), Verificar.class);


                if (txtUsuario.getText().equals("edu") && txtContra.getText().equals("edu97")) {
                    i1.putExtra("user", txtUsuario.getText());
                    i1.putExtra("pass", txtContra.getText());
                    startActivity(i1);
                } else {
                    startActivity(i2);
                }

            }
        });

    }
}
