/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Client;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.ClientCrudRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRep clientCrudRep;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRep.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRep.findById(id);
    }

    public Client save(Client m) {
        return clientCrudRep.save(m);
    }
    
    public void delete(Client m){
        clientCrudRep.delete(m);
    }
}
