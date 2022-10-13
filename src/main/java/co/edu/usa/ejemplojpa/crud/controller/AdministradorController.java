/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.controller;

import co.edu.usa.ejemplojpa.crud.models.Administrador;
import co.edu.usa.ejemplojpa.crud.services.AdministradorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor
 */
@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("api/Admin")
public class AdministradorController {

    @Autowired
    private AdministradorService AdminService;

    @GetMapping("/all")
    public List<Administrador> getAll() {
        return AdminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrador> getAdministrador(@PathVariable("id") int AdministradorId) {
        return AdminService.getAdministrador(AdministradorId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador save(@RequestBody Administrador c) {
        return AdminService.save(c);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador update(@RequestBody Administrador c){
        return AdminService.update(c);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int AdministradorId){
        return AdminService.delete(AdministradorId);
    }
}
