/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Reservation;
import co.edu.usa.ejemplojpa.crud.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository resRep;

    public List<Reservation> getAll() {
        return (List<Reservation>) resRep.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return resRep.getReservation(id);
    }

    public Reservation save(Reservation c) {
        if (c.getIdReservation() == null) {
            c.setStatus("created");
            return resRep.save(c);
        } else {
            Optional<Reservation> caux = resRep.getReservation(c.getIdReservation());
            if (caux.isPresent()) {
                return c;
            } else {
                return resRep.save(c);
            }
        }
    }

    public Reservation update(Reservation c) {

        if (c.getIdReservation() != null) {

            Optional<Reservation> q = resRep.getReservation(c.getIdReservation());

            if (q.isPresent()) {
                if (c.getStartDate() != null) {
                    q.get().setStartDate(c.getStartDate());
                }

                if (c.getDevolutionDate() != null) {
                    q.get().setDevolutionDate(c.getDevolutionDate());
                }
                
                if (c.getStatus() != null) {
                    q.get().setStatus(c.getStatus());
                }
                
                if (c.getMotorbike() != null) {
                    q.get().setMotorbike(c.getMotorbike());
                }

                if (c.getClient() != null) {
                    q.get().setClient(c.getClient());
                }
                
                if (c.getScore() != null) {
                    q.get().setScore(c.getScore());
                }
                
                resRep.save(q.get());
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

        Optional<Reservation> c = resRep.getReservation(id);

        if (c.isPresent()) {
            resRep.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
