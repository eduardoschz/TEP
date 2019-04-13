package com.example.eduardo.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario-03 on 12/04/2019.
 */

public class ControlaBD extends SQLiteOpenHelper {

    public ControlaBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE alumnos(cuenta INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("ALTER TABLE alumnos ADD nombre TEXT ");
    }
}
