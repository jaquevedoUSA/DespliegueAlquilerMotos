/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.controller;

import co.edu.usa.ejemplojpa.crud.models.Motorbike;
import co.edu.usa.ejemplojpa.crud.services.MotorbikeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor
 */
@RestController
@RequestMapping("api/Motorbike")
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getAll() {
        return motorbikeService.getAll();
    }

    @PostMapping("/save")
    public Motorbike save(@RequestBody Motorbike c) {
        return motorbikeService.save(c);
    }
}
