package com.example.apirest.daoserviceimpl;

import com.example.apirest.daoservice.IEtudiantDAO;
import com.example.apirest.services.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoireEtudientDAO implements IEtudiantDAO {
    ArrayList<Etudiant> listEtudiant = new ArrayList<>();
    @Override
    public void persiste(Etudiant e) {
        listEtudiant.add(e);
        System.out.println(e.getNom()+" Persiste en memoire");
    }

    @Override
    public void supprimer(String id) {
        System.out.println("Has Been deleted");
    }

    @Override
    public void mettreAJour(Etudiant e) {
        System.out.println("Has Been Updated");
    }

    @Override
    public int fetchEtudiantCount() {
        return 0;
    }

    @Override
    public int fetchEtudiantCountByNom(String nom) {
        return 0;
    }

    @Override
    public Map fetchEtudiantByNom(String nom) {
        return null;
    }

    @Override
    public List<Map<String, Object>> fetchEtudiantall() {
        return null;
    }

    @Override
    public Etudiant fetchEtudiantByid1(String id) {
        return null;
    }

    @Override
    public List<Etudiant> fetchAllEtudiant() {
        return null;
    }
}
