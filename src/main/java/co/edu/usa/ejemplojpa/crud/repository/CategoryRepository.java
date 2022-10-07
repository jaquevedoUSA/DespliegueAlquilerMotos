/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Category;
import co.edu.usa.ejemplojpa.crud.repository.crudrepository.CategoryCrudRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Category
 */
@Repository
public class CategoryRepository
{
    @Autowired
    private CategoryCrudRep categoryCrudRep;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRep.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRep.findById(id);
    }

    public Category save(Category m) {
        return categoryCrudRep.save(m);
    }
    
    public void delete(Category m){
        categoryCrudRep.delete(m);
    }
}

    

