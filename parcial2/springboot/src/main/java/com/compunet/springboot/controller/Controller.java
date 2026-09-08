package com.compunet.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.compunet.springboot.model.Profesor;
import com.compunet.springboot.repository.ProfesorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Controller {

    private ProfesorRepository profeRepo;

    @Autowired
    public Controller(ProfesorRepository profeRepo) {
        this.profeRepo = profeRepo;
    }

    @GetMapping("/")
    public String home() {
        return new String("Proyecto spring boot funcionando correctamente");
    }
    

    @GetMapping("/profesor")
    public List<Profesor> getProfesores() {
        return profeRepo.findAll();
    }
    

    
}
