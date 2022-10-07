/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Message;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.MessageCrudRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRep messageCrudRep;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRep.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRep.findById(id);
    }

    public Message save(Message m) {
        return messageCrudRep.save(m);
    }
    
    public void delete(Message m){
        messageCrudRep.delete(m);
    }
}
