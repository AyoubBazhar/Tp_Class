package com.example.apirest.controllers;


import com.example.apirest.dto.AjouterEtudiantDTO;
import com.example.apirest.dto.ModifierEtudiantDTO;
import com.example.apirest.services.Etudiant;
import com.example.apirest.services.EtudiantServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {


    private EtudiantServise etudiantServise;

    @Autowired
     public HomeController(EtudiantServise etudiantServise){

         this.etudiantServise = etudiantServise;
     }




    @GetMapping("/etudiant")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> listEtudiant = etudiantServise.rechercherTousEtudients();
        if (listEtudiant.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(listEtudiant);
        }
    }

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable String id) {
        Etudiant etudiant = etudiantServise.fetchEtudiantByid1(id);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/etudiant/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable String id) {
        Etudiant etudiant = etudiantServise.fetchEtudiantByid1(id);
        if (etudiant != null) {
            etudiantServise.supprimerEtudiantByid(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/etudiant")
    public ResponseEntity<AjouterEtudiantDTO> addEtudiant(@RequestBody AjouterEtudiantDTO etudiant) {
        boolean ajout = etudiantServise.AjouterEtudiant(etudiant);
        if(ajout){
            return ResponseEntity.status(HttpStatus.CREATED).body(etudiant);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/etudiant/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable String id, @RequestBody ModifierEtudiantDTO newEtudiant) {
        Etudiant etudiant = etudiantServise.fetchEtudiantByid1(id);
        if (etudiant != null) {
            boolean modif = etudiantServise.ModifierEtudiant(id,newEtudiant);
            if(modif){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }


}
