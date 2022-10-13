/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Administrador;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.AdministradorCrudRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class AdministradorRepository {

    @Autowired
    private AdministradorCrudRep administradorCrudRep;

    public List<Administrador> getAll() {
        return (List<Administrador>) administradorCrudRep.findAll();
    }

    public Optional<Administrador> getAdministrador(int id) {
        return administradorCrudRep.findById(id);
    }

    public Administrador save(Administrador m) {
        return administradorCrudRep.save(m);
    }

    public void delete(Administrador m) {
        administradorCrudRep.delete(m);
    }
    
}
