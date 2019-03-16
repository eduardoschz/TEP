package com.example.controles2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    //CheckBox chkCasado;
    Button btnEnviar;
    RadioButton rbtnHombre, rbtnMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // chkCasado = (CheckBox) findViewById(R.id.chkCasado);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        rbtnHombre = (RadioButton) findViewById(R.id.rbtnHombre);
        rbtnMujer = (RadioButton) findViewById(R.id.rbtnMujer);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtnHombre.isChecked()){
                    Log.i("CheckBox","Eres Hombre");
                }else{
                    Log.i("CheckBox","Eres Mujer");
                }

            }
        });
    }
}
