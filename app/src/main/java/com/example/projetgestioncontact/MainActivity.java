package com.example.projetgestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText nom,password;
     Button valider,quitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.ed_nom_main);
        password=findViewById(R.id.ed_pass_main);

        valider=findViewById(R.id.bt_modifier_modifier);
        quitter=findViewById(R.id.btn_cancel_modifier);



        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=nom.getText().toString();
                String text2=password.getText().toString();
                if (text.equalsIgnoreCase("test")&& text2.equals("123"))
                {

                    //context : activite qui occupe l'ecran
                    Intent i=new Intent(MainActivity.this, Authentification.class);
                    i.putExtra("USER", text);
                    startActivity(i);
                }else{
                    nom.setText("");
                    password.setText("");
                    Toast.makeText(MainActivity.this, "nom ou mot de passe invalide", Toast.LENGTH_SHORT).show();
                }
            }
        });
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             MainActivity.this.finish();
            }
        });


    }
}