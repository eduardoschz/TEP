package com.example.eduardo.datos;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {

    ControlaBD bd;
    SQLiteDatabase crud;
    Cursor apuntador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        SharedPreferences cliente = getSharedPreferences("cliente", Context.MODE_PRIVATE);

        SharedPreferences.Editor escritor = cliente.edit();
            escritor.putString("nombreClientee","Lorena");
            escritor.putInt("edad",21);
            escritor.putBoolean("Femenino",TRUE);
            escritor.commit();

            Log.i("Nombre Cliente",""+cliente.getString("nombreCliente","No sé"));
            */


            try {

                bd = new ControlaBD(this, "FES", null, 3);
                crud = bd.getWritableDatabase();
                //INSERT
                //crud.execSQL("DELETE FROM alumnos");
                crud.execSQL("INSERT INTO alumnos VALUES(313081)");
                apuntador = crud.rawQuery("SELECT * FROM alumnos", null);

                if (apuntador.moveToFirst()) {
                    do {
                        Log.i("Cuenta", "" + apuntador.getInt(0));
                    } while (apuntador.moveToNext());
                }
            }catch (Exception e){
                Log.e("Error", e.getMessage());
            }
    }
}
