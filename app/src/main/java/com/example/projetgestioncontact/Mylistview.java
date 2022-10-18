package com.example.projetgestioncontact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class Mylistview extends BaseAdapter {
    ArrayList<Contact> data;
    Context con;
    public int id;
    public Mylistview(ArrayList<Contact> data, Context con) {
        this.data = data;
        this.con = con;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CardView l = null;
        id=i;
        LayoutInflater inf = LayoutInflater.from(con);
        l = (CardView) inf.inflate(R.layout.activity_view_contact, null);
        /*recuperer les holders*/
        TextView nom = l.findViewById(R.id.tv_nom_contact);
        TextView prenom = l.findViewById(R.id.tv_prenom_contact);
        TextView numero = l.findViewById(R.id.tv_numero_contact);
        ImageView call = l.findViewById(R.id.imagecall);
        ImageView delete = l.findViewById(R.id.imagedelete);
        ImageView edit = l.findViewById(R.id.imageedit);


        Contact c = data.get(i);
        nom.setText(c.getNom());
        prenom.setText(c.getPrenom());
        numero.setText(c.getNumero());

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(con, Authentification.class);
                i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + c.getNumero()));
                con.startActivity(i);

                //Intent i = new Intent(Intent.ACTION_CALL);
            }
        });
       /* delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=data.get(i).getPrenom()+" "+data.get(i).getNom();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(con);
                builder1.setMessage("Do you confirm to delete "+user);
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Authentification.contactManager.supprimer(data.get(i).getId());
                                Toast.makeText(con, user+" has been deleted", Toast.LENGTH_SHORT).show();
                                ((Activity)(con)).finish();
                                Intent i = new Intent(con, Edit.class);
                                con.startActivity(i);                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        });*/
       /* edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact c=data.get(i);
                //Intent i = new Intent(con, EditForm.class);
              //  i.putExtra("id", String.valueOf(c.getId()));

                i.putExtra("nom", c.getNom());
                i.putExtra("prenom", c.getPrenom());
                i.putExtra("num", c.getNumero());

                con.startActivity(i);


            }
        });*/
        return l;
    }
}
