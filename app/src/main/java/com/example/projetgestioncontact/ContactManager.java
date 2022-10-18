package com.example.projetgestioncontact;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db = null;
    Context con;

    public ContactManager(Context con) {
        this.con = con;
    }

    public void ouvrir() {
        ContactHelper helper = new ContactHelper(con, "mabase.db", null, 2);
        db = helper.getWritableDatabase();

    }

    public long ajout(String nom, String prenom, String numero) {
        long a = 0;
        ContentValues values = new ContentValues();
        values.put(ContactHelper.col_nom, nom);
        values.put(ContactHelper.col_prenom, prenom);
        values.put(ContactHelper.col_numero, numero);
        a = db.insert(ContactHelper.table, null, values);
        return a;

    }

    public ArrayList<Contact> getAllContact() {
        ArrayList<Contact> l = new ArrayList<Contact>();
        Cursor c = db.query(ContactHelper.table,
                new String[]{
                        ContactHelper.col_id,
                        ContactHelper.col_nom,
                        ContactHelper.col_prenom,
                        ContactHelper.col_numero
                }, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            System.out.println(c.getString(1));

            l.add(new Contact(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
            c.moveToNext();
        }

        return l;
    }
    public boolean modifiertel(int id, String nom, String prenom,String numero){

        ContentValues values = new ContentValues();
        values.put(ContactHelper.col_id, id);
        values.put(ContactHelper.col_nom, nom);
        values.put(ContactHelper.col_prenom, prenom);
        values.put(ContactHelper.col_numero, numero);

        db.update(ContactHelper.table,values,"id = ?",new String[] {String.valueOf(id)});
        return true;


    }
    public void supprimer(int id) {
        db.delete(ContactHelper.table, "id=?", new String[]{String.valueOf(id)});
    }

    public void fermer() {

    }
}
