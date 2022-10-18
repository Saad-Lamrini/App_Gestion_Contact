package com.example.projetgestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {
    TextView nom,prenom,tel;
    Button modifier,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        nom=findViewById(R.id.ed_nom_edit);
        prenom=findViewById(R.id.ed_prenom_edit);
        tel=findViewById(R.id.ed_tel_edit);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        String u=b.getString("nom");
        String u1=b.getString("prenom");
        String u2=b.getString("num");
       nom.setText(u);
       prenom.setText(u1);
       tel.setText(u2);
cancel=findViewById(R.id.btn_cancel_modifier);
cancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(Edit.this, Authentification.class);

        startActivity(i);
    }
});
        modifier=findViewById(R.id.bt_modifier_modifier);
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t=0;
                String t1=nom.getText().toString();
                String t2=prenom.getText().toString();
                String t3=tel.getText().toString();
                ArrayList<Contact> d=Authentification.contactManager.getAllContact();
                for (int c = 0; c < d.size(); c++) {
                    if ((d.get(c).nom.equals(t1)) &&(d.get(c).prenom.equals(t2))) {

                        t=d.get(c).id;
                    }
                }
                if (t==0){
                    Toast.makeText(Edit.this, "Contact non existant", Toast.LENGTH_SHORT).show();

                }else{
                    boolean a=Authentification.contactManager.modifiertel(t,t1,t2,t3);
                    if(a=true){
                        Toast.makeText(Edit.this, "Contact modifie", Toast.LENGTH_SHORT).show();
                        nom.setText("");
                        prenom.setText("");
                        tel.setText("");
                    }else{
                        Toast.makeText(Edit.this, "Contact non modifie", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}