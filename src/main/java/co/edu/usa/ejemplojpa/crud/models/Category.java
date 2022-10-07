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
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 45, nullable = false, unique = false)
    private String name;

    @Column(name = "description", length = 250, nullable = false, unique = false)
    private String description;

    //@JoinColumn(name="category")
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Motorbike> motorbikes;

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(Integer id, String name, String description, List<Motorbike> motorbikes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.motorbikes = motorbikes;
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
     * @return the motorbikes
     */
    public List<Motorbike> getMotorbikes() {
        return motorbikes;
    }

    /**
     * @param motorbikes the motorbikes to set
     */
    public void setMotorbikes(List<Motorbike> motorbikes) {
        this.motorbikes = motorbikes;
    }

}
