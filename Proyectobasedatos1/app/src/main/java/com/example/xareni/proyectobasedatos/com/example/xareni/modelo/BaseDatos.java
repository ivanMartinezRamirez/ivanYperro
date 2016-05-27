package com.example.xareni.proyectobasedatos.com.example.xareni.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Xareni on 18/05/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {


    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table persona(clave integer primary key, nombre text, paterno text, materno text)");
        //cuando se instancia la clase se crea la base, cuando se vueleve a ejecutar el entorno detecta si ya existe y ya no lo crea
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists persona");
        db.execSQL("create table persona(clave integer primary key, nombre text, paterno text, materno text)");


    }
}
