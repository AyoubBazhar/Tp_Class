package com.example.apirest.daoservice;

import com.example.apirest.services.Etudiant;

import java.util.List;
import java.util.Map;

public interface IEtudiantDAO {
    void persiste(Etudiant e);

    void supprimer(String id);

    void mettreAJour(Etudiant e);

    public int fetchEtudiantCount();

    int fetchEtudiantCountByNom(String nom);

    Map fetchEtudiantByNom(String nom);

    List<Map<String, Object>> fetchEtudiantall();

    Etudiant fetchEtudiantByid1(String id);

    List<Etudiant> fetchAllEtudiant();
}
