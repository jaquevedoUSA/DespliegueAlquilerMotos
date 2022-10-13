/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository.crudrepository;

import co.edu.usa.ejemplojpa.crud.models.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Moto
 */

public interface ReservationCrudRep extends CrudRepository<Reservation, Integer>
{

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date a, Date b);
        //Cantidad de reservas completas vs canceladas
    public List<Reservation> findAllByStatus(String status);
    
    //Top de los clientes que más dinero le han dejado a la compañía.
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
}
