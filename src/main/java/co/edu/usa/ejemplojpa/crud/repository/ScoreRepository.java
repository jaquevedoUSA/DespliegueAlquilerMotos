/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Score;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.ScoreCrudRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRep scoreCrudRep;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRep.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRep.findById(id);
    }

    public Score save(Score m) {
        return scoreCrudRep.save(m);
    }

    public void delete(Score m) {
        scoreCrudRep.delete(m);
    }
    
}
