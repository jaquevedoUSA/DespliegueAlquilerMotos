/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author USER2022
 */
@Entity
@Table(name = "score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;

    @Column(name = "messageText", length = 250, nullable = false, unique = false)
    private String messageText;
    
    @Column(name = "stars", length = 45, nullable = false, unique = false)
    private Integer stars;

    @OneToOne
    @JoinColumn(name = "reservation")
    @JsonIgnoreProperties({"score"})
    private Reservation reservation;
    
    public Score() {
    }

    public Score(Integer idScore) {
        this.idScore = idScore;
    }

    public Score(Integer idScore, String messageText, Integer stars, Reservation reservation) {
        this.idScore = idScore;
        this.messageText = messageText;
        this.stars = stars;
        this.reservation = reservation;
    }

    /**
     * @return the idScore
     */
    public Integer getIdScore() {
        return idScore;
    }

    /**
     * @param idScore the idScore to set
     */
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    /**
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * @return the stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * @param stars the stars to set
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * @return the reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    
}
