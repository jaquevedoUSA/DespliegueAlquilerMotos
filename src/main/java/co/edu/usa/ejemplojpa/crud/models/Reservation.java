/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jaque
 */

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column(name = "startDate", nullable = false, unique = false)
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;

    @Column(name = "devolutionDate", nullable = false, unique = false)
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date devolutionDate;

    @Column(name = "status", nullable = true, unique = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "motorbike")
    @JsonIgnoreProperties("reservations")
    private Motorbike motorbike;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

     @OneToOne
    @JoinColumn(name = "score")
    @JsonIgnoreProperties({"reservation","messageText"})
    private Score score;

    public Reservation() {
    }

    public Reservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Reservation(Integer idReservation, Date startDate, Date devolutionDate, String status, Motorbike motorbike, Client client, Score score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.motorbike = motorbike;
        this.client = client;
        this.score = score;
    }

    /**
     * @return the idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * @param idReservation the idReservation to set
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * @param devolutionDate the devolutionDate to set
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the motorbike
     */
    public Motorbike getMotorbike() {
        return motorbike;
    }

    /**
     * @param motorbike the motorbike to set
     */
    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the score
     */
    public Score getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Score score) {
        this.score = score;
    }
    
    
}