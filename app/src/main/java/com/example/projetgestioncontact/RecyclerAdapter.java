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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    ArrayList<Contact> data;
    Context con;
    TextView nom;
    TextView prenom;
    TextView numero;

    public RecyclerAdapter(ArrayList<Contact> data, Context con) {
        this.data = data;
        this.con = con;
    }


    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        LayoutInflater inf = LayoutInflater.from(con);
        v = (View) inf.inflate(R.layout.activity_view_contact, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        Contact c = data.get(position);
        nom.setText(c.getNom());
        prenom.setText(c.getPrenom());
        numero.setText(c.getNumero());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View v) {
            super(v);
            //represente les holders

                nom = v.findViewById(R.id.tv_nom_contact);
                prenom = v.findViewById(R.id.tv_prenom_contact);
                numero = v.findViewById(R.id.tv_numero_contact);
                ImageView call = v.findViewById(R.id.imagecall);
                ImageView delete = v.findViewById(R.id.imagedelete);
                ImageView edit = v.findViewById(R.id.imageedit);

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = getAdapterPosition();
                    Contact c = data.get(id);
                    nom.setText(c.getNom());
                    prenom.setText(c.getPrenom());
                    numero.setText(c.getNumero());
                    Intent i = new Intent(con, Authentification.class);
                    i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + c.getNumero()));
                    con.startActivity(i);

                    //Intent i = new Intent(Intent.ACTION_CALL);
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = getAdapterPosition();
                    Contact c = data.get(i);
                    nom.setText(c.getNom());
                    prenom.setText(c.getPrenom());
                    numero.setText(c.getNumero());
                    String user=data.get(i).getPrenom()+" "+data.get(i).getNom();
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(con);
                    builder1.setMessage("tu veux encore le supprimer"+user);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    Authentification.contactManager.supprimer(data.get(i).getId());
                                    Toast.makeText(con, user+" est supprime", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                    ((Activity)(con)).finish();
                                    Intent i = new Intent(con, Afficher_tout.class);
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
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = getAdapterPosition();
                    Contact c = data.get(id);
                    nom.setText(c.getNom());
                    prenom.setText(c.getPrenom());
                    numero.setText(c.getNumero());
                    Intent i = new Intent(con, Edit.class);
                    i.putExtra("id", String.valueOf(c.getId()));

                    i.putExtra("nom", c.getNom());
                    i.putExtra("prenom", c.getPrenom());
                    i.putExtra("num", c.getNumero());

                    con.startActivity(i);


                }
            });
        }
    }
}
