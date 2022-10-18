package com.example.projetgestioncontact;

public class Contact {
    public int id;
    public String nom;
    public String prenom;
    public String numero;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public Contact(String nom, String prenom, String numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }
    public Contact(int id,String nom, String prenom, String numero) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
