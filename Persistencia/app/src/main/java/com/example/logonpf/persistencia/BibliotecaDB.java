package com.example.logonpf.persistencia;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

public class BibliotecaDB extends OrmLiteSqliteOpenHelper{

    public BibliotecaDB(Context context) {
        super(context, "BIBLIOTECADB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database,
                         ConnectionSource connectionSource) {

        database.execSQL("CREATE TABLE TAB_LIVRO(ID INTEGER " +
                "PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "DES_TITULO VARCHAR2(50)," +
                "NOM_AUTOR VARCHAR2(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {

    }
}
