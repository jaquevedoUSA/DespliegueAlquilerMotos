/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Client;
import co.edu.usa.ejemplojpa.crud.models.Reservation;
import co.edu.usa.ejemplojpa.crud.models.custom.CountClient;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.ReservationCrudRep;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRep reservationCrudRep;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRep.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRep.findById(id);
    }

    public Reservation save(Reservation m) {
        return reservationCrudRep.save(m);
    }

    public void delete(Reservation m) {
        reservationCrudRep.delete(m);
    }
    
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRep.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRep.findAllByStatus(status);
    }
    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();
        
        List<Object[]> report=reservationCrudRep.countTotalReservationByClient();
        for (int i=0; i<report.size(); i++) {
            Client cliente=(Client) report.get(i)[0];
            Long cantidad=(Long)report.get(i)[1];
            CountClient cclient=new CountClient(cantidad, cliente);
            res.add(cclient);
        }
        return res;
    }
}
