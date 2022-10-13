/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository.crudrepository;

import co.edu.usa.ejemplojpa.crud.models.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Moto
 */

public interface ScoreCrudRep extends CrudRepository<Score, Integer>
{
    
}
