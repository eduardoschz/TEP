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
                Intent i = new Intent(getBaseContext(),MainActivity.class);

                i.putExtra("user", txtUsuario.getText());
                i.putExtra("pass", txtContra.getText());

                if (txtUsuario.getText() == "eduardo" && txtContra.getText() =="edu1297"){
                    startActivity(i);
                }

            }
        });

    }
}
