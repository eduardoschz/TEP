package com.example.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ConstraintLayout consFondo;
    MediaPlayer izquierda, derecha, adelante, atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensor = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor.registerListener(this, sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        consFondo = findViewById(R.id.consFondo);
        izquierda = MediaPlayer.create(this, R.raw.izquierda);
        derecha = MediaPlayer.create(this, R.raw.derecha);
        adelante = MediaPlayer.create(this, R.raw.adelante);
        atras = MediaPlayer.create(this, R.raw.atras);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.i("Valor1 ", " " + event.values[0]);
        Log.i("Valor2", " " + event.values[1]);
        Log.i("Valor3", " " + event.values[2]);

       if (event.values[0] > 5.0f) {
            izquierda.start();
        } else if (event.values[0] < -5.0f) {
            derecha.start();
        } else if (event.values[2] > 5.0f) {
            adelante.start();
        }else if (event.values[2] < -5.0f){
            atras.start();
        }

        /* if(event.values[0]<100){
            consFondo.setBackgroundColor(Color.RED);
        }else{
            consFondo.setBackgroundColor(Color.WHITE);
        }*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
