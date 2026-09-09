package com.compunet.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import com.compunet.springboot.model.Curso;
import com.compunet.springboot.model.Departamento;
import com.compunet.springboot.model.Profesor;
import com.compunet.springboot.repository.CursoRepository;
import com.compunet.springboot.repository.DepartamentoRepository;
import com.compunet.springboot.repository.ProfesorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {

    private ProfesorRepository profeRepo;
    private CursoRepository cursoRepo;
    private DepartamentoRepository deptRepo;

    @Autowired
    public Controller(ProfesorRepository profeRepo, CursoRepository cursoRepo, DepartamentoRepository deptRepo) {
        this.profeRepo = profeRepo;
        this.cursoRepo = cursoRepo;
        this.deptRepo = deptRepo;
    }

    @GetMapping("/")
    public String home() {
        return new String("Proyecto spring boot funcionando correctamente");
    }
    

    @GetMapping("/profesor")
    public List<Profesor> getProfesores() {
        return profeRepo.findAll();
    }

    @GetMapping("/curso")
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @GetMapping("/departamento")
    public List<Departamento> getDepartamentos() {
        return deptRepo.findAll();
    }

}
