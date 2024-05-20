package com.example.apirest.daoserviceimpl;

import com.example.apirest.Mappers.EtudiantRowMapper;
import com.example.apirest.daoservice.IEtudiantDAO;
import com.example.apirest.services.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class MysqlDAO implements IEtudiantDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public MysqlDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void persiste(Etudiant e) {
        String sql = "INSERT INTO Etudiant (id, nom, prenom) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, e.getId() , e.getNom(), e.getPrenom());
    }

    public void mettreAJour(Etudiant e) {
        String sql = "UPDATE Etudiant SET nom = ?, prenom = ? WHERE id = ?";
        jdbcTemplate.update(sql, e.getNom(), e.getPrenom(), e.getId());
    }

    public void supprimer(String id) {
        String sql = "DELETE FROM Etudiant WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    public int fetchEtudiantCount() {
        String sql = "SELECT COUNT(*) FROM Etudiant";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int fetchEtudiantCountByNom(String nom) {
        String sql = "SELECT COUNT(*) FROM Etudiant where nom = ?";
        return this.jdbcTemplate.queryForObject(sql, Integer.class,nom);
    }


    public Map fetchEtudiantByNom(String nom) {
        String sql = "SELECT * FROM Etudiant WHERE nom = ?";
        return this.jdbcTemplate.queryForMap(sql, nom);
    }


    public List<Map<String, Object>> fetchEtudiantall() {
        String sql = "SELECT * FROM Etudiant";
        return this.jdbcTemplate.queryForList(sql);
    }



    public Etudiant fetchEtudiantByid1(String id) {
        String sql = "SELECT * FROM Etudiant WHERE id = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new EtudiantRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }



    public List<Etudiant> fetchAllEtudiant() {
        String sql = "SELECT * FROM Etudiant";
        return this.jdbcTemplate.query(sql, new EtudiantRowMapper());
    }


}
