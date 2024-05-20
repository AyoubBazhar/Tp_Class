package com.example.apirest.Mappers;

import com.example.apirest.services.Etudiant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantRowMapper implements RowMapper<Etudiant> {
    @Override
    public Etudiant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Etudiant p = new Etudiant();
        p.setId(rs.getString("id"));
        p.setNom(rs.getString("nom"));
        p.setPrenom(rs.getString("prenom"));
        return p;
    }
}

