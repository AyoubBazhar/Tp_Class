package com.example.apirest.dto;

import org.springframework.stereotype.Component;

@Component
public class AjouterEtudiantDTO {
    private String nom;
    private String prenom;

    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
