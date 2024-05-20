package com.example.apirest.services;


import org.springframework.stereotype.Component;

@Component
public class Etudiant {
    private String id;
    private String nom;
    private String prenom;

    public Etudiant(String id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public void display(){
        System.out.println(this.id+" "+this.nom+" "+this.prenom);
    }
}
