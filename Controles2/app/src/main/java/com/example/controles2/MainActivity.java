package com.example.controles2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //CheckBox chkCasado;
    Button btnEnviar;
    RadioButton rbtnHombre, rbtnMujer;
    Spinner spinIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //chkCasado = (CheckBox) findViewById(R.id.chkCasado);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        rbtnHombre = (RadioButton) findViewById(R.id.rbtnHombre);
        rbtnMujer = (RadioButton) findViewById(R.id.rbtnMujer);
        spinIdioma = (Spinner) findViewById(R.id.spinIdioma);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtnHombre.isChecked()){
                    Log.i("CheckBox","Eres Hombre");
                }else{
                    Log.i("CheckBox","Eres Mujer");
                }

                Log.e("Idioma",spinIdioma.getSelectedItem().toString());

                Intent i = new Intent(getBaseContext(),SegundaActividad.class);

                i.putExtra("name","Eduardo");
                startActivity(i);
            }
        });
    }
}
