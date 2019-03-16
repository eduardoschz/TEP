package com.example.aplicacion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Bienvenido extends AppCompatActivity {

    TextView txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        Bundle b = getIntent().getExtras();
        txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(b.getString("user"));

    }
}
