package com.example.projetgestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Authentification extends AppCompatActivity {
     TextView nomuser;
     Button ajouter,editer,affiche;
    public static ContactManager contactManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        contactManager = new ContactManager(Authentification.this);
        contactManager.ouvrir();
        affiche=findViewById(R.id.button_afficher_auth);
        nomuser=findViewById(R.id.tv_acceuil_main);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        String u=b.getString("USER");
        nomuser.setText(nomuser.getText().toString()+":"+u);
        ajouter=findViewById(R.id.bt_ajout_auth);
        editer=findViewById(R.id.btn_editer_auth);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Authentification.this,Ajouter.class);
                startActivity(i);
            }
        });
        editer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Authentification.this,Edit.class);
                startActivity(i);
            }
        });
        affiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Authentification.this,Afficher_tout.class);
                startActivity(i);
            }
        });

    }
}