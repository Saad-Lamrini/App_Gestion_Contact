package com.example.projetgestioncontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Afficher_tout extends AppCompatActivity {
      RecyclerView lv;
      //ArrayAdapter ad;
    static RecyclerAdapter ad;
      Mylistview l1;
      TextView recherche;
    ArrayList<Contact> search_data = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        recherche=findViewById(R.id.recherche);
        lv=findViewById(R.id.lv );
        //ad = new ArrayAdapter(Afficher_tout.this, android.R.layout.simple_list_item_1, Authentification.contactManager.getAllContact());
       // l1 = new Mylistview(Authentification.contactManager.getAllContact(), Afficher_tout.this);
        //lv.setAdapter(l1);
       // lv.setAdapter(ad);


        ad=new RecyclerAdapter(Authentification.contactManager.getAllContact(), Afficher_tout.this);
        lv.setAdapter(ad);
        recherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Contact> d=Authentification.contactManager.getAllContact();
                //ad = new ArrayAdapter(Afficher_tout.this, android.R.layout.simple_list_item_1, d);
               // l1 = new Mylistview(d, Afficher_tout.this);
                ad = new RecyclerAdapter(d,Afficher_tout.this);
                //lv.setAdapter(ad);
                search_data.clear();
                for (int c = 0; c < d.size(); c++) {
                    if (d.get(c).nom.startsWith(charSequence.toString()) ||
                            d.get(c).prenom.startsWith(charSequence.toString()) ||
                            d.get(c).numero.startsWith(charSequence.toString())) {
                        search_data.add(d.get(c));
                    }
                }

               // ad = new ArrayAdapter(Afficher_tout.this, android.R.layout.simple_list_item_1, search_data);
                //lv.setAdapter(ad);

              //  l1 = new Mylistview(search_data, Afficher_tout.this);
               // lv.setAdapter(l1);
                ad= new RecyclerAdapter(search_data, Afficher_tout.this);
                lv.setAdapter(ad);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}