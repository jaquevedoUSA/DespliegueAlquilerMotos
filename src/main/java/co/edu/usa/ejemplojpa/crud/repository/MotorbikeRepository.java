/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Motorbike;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.MotorbikeCrudRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class MotorbikeRepository {

    @Autowired
    private MotorbikeCrudRep motorbikeCrudRep;

    public List<Motorbike> getAll() {
        return (List<Motorbike>) motorbikeCrudRep.findAll();
    }

    public Optional<Motorbike> getMotorbike(int id) {
        return motorbikeCrudRep.findById(id);
    }

    public Motorbike save(Motorbike m) {
        return motorbikeCrudRep.save(m);
    }
    
    public void delete(Motorbike m){
        motorbikeCrudRep.delete(m);
    }
}
