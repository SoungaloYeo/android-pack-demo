package com.app.sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "etablissement.db";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {
        sqLiteDB.execSQL("CREATE TABLE " + MyDBSchema.Etudiant.TABLE_NAME + "( "
                + MyDBSchema.Etudiant.MyColumns.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MyDBSchema.Etudiant.MyColumns.NOM + " TEXT,"
                + MyDBSchema.Etudiant.MyColumns.PRENOM + " TEXT,"
                + MyDBSchema.Etudiant.MyColumns.FILIERE +" TEXT,"
                + MyDBSchema.Etudiant.MyColumns.COMMUNE +" TEXT)"
        );

        sqLiteDB.execSQL("CREATE TABLE " + MyDBSchema.Salle.TABLE_NAME + "( "
                +MyDBSchema.Salle.MyColumns.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MyDBSchema.Salle.MyColumns.DESIGN + " TEXT,"
                + MyDBSchema.Salle.MyColumns.NBR_PLACE + " TEXT)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDB, int oldVersion, int newVersion) {
        sqLiteDB.execSQL("DROP TABLE IF EXISTS "+ MyDBSchema.Etudiant.TABLE_NAME);
        sqLiteDB.execSQL("DROP TABLE IF EXISTS "+ MyDBSchema.Salle.TABLE_NAME);
        onCreate(sqLiteDB);
    }
}
