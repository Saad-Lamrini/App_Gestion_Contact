package com.example.projetgestioncontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {
    public static final String table = "contact";
    public static final String col_id = "id";
    public static final String col_nom = "nom";
    public static final String col_prenom = "prenom";
    public static final String col_numero = "numero";

    String query = "create table " + table + "(" + col_id + " integer primary key autoincrement," +
            col_nom + " text not null, " + col_prenom + " text not null ," + col_numero + " text not null);";

    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table" + table);
        onCreate(sqLiteDatabase);
    }

}
