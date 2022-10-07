/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Client;
import co.edu.usa.ejemplojpa.crud.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository cr;

    public List<Client> getAll() {
        return (List<Client>) cr.getAll();
    }

    public Optional<Client> getClient(int id) {
        return cr.getClient(id);
    }

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return cr.save(c);
        } else {
            Optional<Client> caux = cr.getClient(c.getIdClient());
            if (caux.isPresent()) {
                return c;
            } else {
                return cr.save(c);
            }
        }
    }

    public Client update(Client c) {

        if (c.getIdClient() != null) {

            Optional<Client> q = cr.getClient(c.getIdClient());

            if (q.isPresent()) {
                
                if (c.getEmail() != null) {
                    q.get().setEmail(c.getEmail());
                }
                
                if (c.getPassword() != null) {
                    q.get().setPassword(c.getPassword());
                }
                
                if (c.getName() != null) {
                    q.get().setName(c.getName());
                }

                if (c.getAge() != null) {
                    q.get().setAge(c.getAge());
                }

                if (c.getMessages() != null) {
                    q.get().setMessages(c.getMessages());
                }
                
                if (c.getReservations() != null) {
                    q.get().setReservations(c.getReservations());
                }
                
                cr.save(q.get());
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

        Optional<Client> c = cr.getClient(id);

        if (c.isPresent()) {
            cr.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
