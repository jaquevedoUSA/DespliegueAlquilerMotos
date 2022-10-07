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
@Table(name = "motorbike")
public class Motorbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 45, nullable = false, unique = false)
    private String name;

    @Column(name = "brand", length = 45, nullable = false, unique = false)
    private String brand;

    @Column(name = "year", length = 4, nullable = false, unique = false)
    private Integer year;

    @Column(name = "description", length = 250, nullable = false, unique = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("motorbikes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties("motorbike")
    private List<Reservation> reservations;

    public Motorbike() {
    }

    public Motorbike(Integer id) {
        this.id = id;
    }

    public Motorbike(Integer id, String name, String brand, Integer year, String description, Category category, List<Message> messages, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }

    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
