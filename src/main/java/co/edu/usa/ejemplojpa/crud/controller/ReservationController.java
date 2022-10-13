/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.controller;

import co.edu.usa.ejemplojpa.crud.models.Reservation;
import co.edu.usa.ejemplojpa.crud.models.custom.CountClient;
import co.edu.usa.ejemplojpa.crud.models.custom.StatusAmount;
import co.edu.usa.ejemplojpa.crud.services.ReservationService;
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
@RequestMapping("api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int ReservationId) {
        return reservationService.getReservation(ReservationId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c) {
        return reservationService.save(c);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation c){
        return reservationService.update(c);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ReservationId){
        return reservationService.delete(ReservationId);
    }
    
    @GetMapping("/report-dates/{date-one}/{date-two}")
    public List<Reservation> getReservationDates(
            @PathVariable("date-one") String dateOne,
            @PathVariable("date-two") String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }
    
    @GetMapping("/report-status")
    public StatusAmount getStatusAmountStatus(){
        return reservationService.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getCountClients(){
        return reservationService.getTopClient();
    }
}
