/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Motorbike;
import co.edu.usa.ejemplojpa.crud.repository.MotorbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository mr;

    public List<Motorbike> getAll() {
        return (List<Motorbike>) mr.getAll();
    }

    public Optional<Motorbike> getMotorbike(int id) {
        return mr.getMotorbike(id);
    }

    public Motorbike save(Motorbike c) {
        if (c.getId() == null) {
            return mr.save(c);
        } else {
            Optional<Motorbike> caux = mr.getMotorbike(c.getId());
            if (caux.isPresent()) {
                return c;
            } else {
                return mr.save(c);
            }
        }
    }

    public Motorbike update(Motorbike c) {

        if (c.getId() != null) {

            Optional<Motorbike> q = mr.getMotorbike(c.getId());

            if (q.isPresent()) {
                if (c.getName() != null) {
                    q.get().setName(c.getName());
                }

                if (c.getBrand() != null) {
                    q.get().setBrand(c.getBrand());
                }
                
                if (c.getYear() != null) {
                    q.get().setYear(c.getYear());
                }
                
                if (c.getDescription() != null) {
                    q.get().setDescription(c.getDescription());
                }

                if (c.getCategory() != null) {
                    q.get().setCategory(c.getCategory());
                }
                
                if (c.getMessages() != null) {
                    q.get().setMessages(c.getMessages());
                }
                
                if (c.getReservations() != null) {
                    q.get().setReservations(c.getReservations());
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

        Optional<Motorbike> c = mr.getMotorbike(id);

        if (c.isPresent()) {
            mr.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
