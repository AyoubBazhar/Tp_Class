package com.example.apirest.services;

import com.example.apirest.daoservice.IEtudiantDAO;
import com.example.apirest.dto.AjouterEtudiantDTO;
import com.example.apirest.dto.ModifierEtudiantDTO;
import com.example.apirest.idgeneratorservice.IdGenerateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServise {
    @Autowired
    @Qualifier("mysqlDAO")
    private IEtudiantDAO etudientDAO;

    @Autowired
    @Qualifier("timeStampIdGenerateur")
    private IdGenerateur idGenerateur;
    public void ajouterEtudiant(Etudiant e) {
        e.setId(idGenerateur.generateId());
        etudientDAO.persiste(e);
    }
    public List<Etudiant> rechercherTousEtudients() {
        return etudientDAO.fetchAllEtudiant();
    }

    public Etudiant fetchEtudiantByid1(String id) {
        return etudientDAO.fetchEtudiantByid1(id);
    }

    public void supprimerEtudiantByid(String id) {
        etudientDAO.supprimer(id);
    }

    public boolean AjouterEtudiant(AjouterEtudiantDTO etudiant) {
        try {
            if(etudiant.getNom() != null && etudiant.getprenom() != null){
                Etudiant etu = new Etudiant();
                etu.setNom(etudiant.getNom());
                etu.setPrenom(etudiant.getprenom());
                etu.setId(idGenerateur.generateId());
                etudientDAO.persiste(etu);
                return true;
            }
            return false;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ModifierEtudiant(String id , ModifierEtudiantDTO etudiant) {
        try {
            if(etudiant.getNom() != null && etudiant.getprenom() != null && id != null){
                Etudiant etu = new Etudiant();
                etu.setId(id);
                etu.setNom(etudiant.getNom());
                etu.setPrenom(etudiant.getprenom());
                etudientDAO.mettreAJour(etu);
                return true;
            }
            return false;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
