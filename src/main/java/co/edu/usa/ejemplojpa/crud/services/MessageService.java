/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Message;
import co.edu.usa.ejemplojpa.crud.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository mr;

    public List<Message> getAll() {
        return (List<Message>) mr.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return mr.getMessage(id);
    }

    public Message save(Message c) {
        if (c.getIdMessage() == null) {
            return mr.save(c);
        } else {
            Optional<Message> caux = mr.getMessage(c.getIdMessage());
            if (caux.isPresent()) {
                return c;
            } else {
                return mr.save(c);
            }
        }
    }

    public Message update(Message c) {

        if (c.getIdMessage() != null) {

            Optional<Message> q = mr.getMessage(c.getIdMessage());

            if (q.isPresent()) {
                if (c.getMessageText() != null) {
                    q.get().setMessageText(c.getMessageText());
                }

                if (c.getMotorbike() != null) {
                    q.get().setMotorbike(c.getMotorbike());
                }
                
                if (c.getClient() != null) {
                    q.get().setClient(c.getClient());
                }
                
                mr.save(q.get());
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

        Optional<Message> c = mr.getMessage(id);

        if (c.isPresent()) {
            mr.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
