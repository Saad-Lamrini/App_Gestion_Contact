package com.example.projetgestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ajouter extends AppCompatActivity {
    TextView nomuser,prenomuser,teluser;
    Button ajouter,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        nomuser=findViewById(R.id.ed_nom_edit);
        prenomuser=findViewById(R.id.ed_prenom_edit);
        teluser=findViewById(R.id.ed_tel_edit);

        ajouter=findViewById(R.id.bt_modifier_modifier);
        cancel=findViewById(R.id.btn_cancel_modifier);

       ajouter.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String nom=nomuser.getText().toString();
               String prenom=prenomuser.getText().toString();
               String tel=teluser.getText().toString();

               if (nom.isEmpty() && prenom.isEmpty() && tel.isEmpty()) {
                   Toast.makeText(Ajouter.this, "Cannot be empty", Toast.LENGTH_SHORT).show();

               } else {

                   long a = Authentification.contactManager.ajout(nom, prenom, tel);



                   Toast.makeText(Ajouter.this, "New Contact Added", Toast.LENGTH_SHORT).show();

                   nomuser.setText("");
                   prenomuser.setText("");
                   teluser.setText("");
               }
           }
       });
       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(Ajouter.this, Authentification.class);

               startActivity(i);
           }
       });
    }
}