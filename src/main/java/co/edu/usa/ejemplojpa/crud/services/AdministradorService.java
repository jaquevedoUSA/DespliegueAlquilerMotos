/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Administrador;
import co.edu.usa.ejemplojpa.crud.repository.AdministradorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository adminRep;

    public List<Administrador> getAll() {
        return (List<Administrador>) adminRep.getAll();
    }

    public Optional<Administrador> getAdministrador(int id) {
        return adminRep.getAdministrador(id);
    }

    public Administrador save(Administrador c) {
        if (c.getId() == null) {
            return adminRep.save(c);
        } else {
            Optional<Administrador> caux = adminRep.getAdministrador(c.getId());
            if (caux.isPresent()) {
                return c;
            } else {
                return adminRep.save(c);
            }
        }
    }

    public Administrador update(Administrador c) {

        if (c.getId() != null) {

            Optional<Administrador> q = adminRep.getAdministrador(c.getId());

            if (q.isPresent()) {
                if (c.getName() != null) {
                    q.get().setName(c.getName());
                }

                if (c.getPassword() != null) {
                    q.get().setPassword(c.getPassword());
                }
                
                if (c.getEmail() != null) {
                    q.get().setEmail(c.getEmail());
                }

                adminRep.save(q.get());
                return q.get();
            } else {
                return c;
            }
        } else {
            return c;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;

        Optional<Administrador> c = adminRep.getAdministrador(id);

        if (c.isPresent()) {
            adminRep.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
