package com.example.controles2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {
    TextView txtEjemplo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        txtEjemplo = (TextView) findViewById(R.id.txtName);

        Bundle monton = getIntent().getExtras();
        String name = monton.getString("name");
        txtEjemplo.setText(""+name);
        Log.e("Nombre recibido: ",name);
    }
}
