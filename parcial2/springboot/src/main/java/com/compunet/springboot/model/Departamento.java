package com.compunet.springboot.model;

import java.util.List;

import org.springframework.boot.jackson.autoconfigure.JacksonProperties.Json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column (name = "edificio", nullable = true)
    private String edificio;


    @OneToMany(mappedBy = "departamento")
    @JsonIgnoreProperties(value = "departamento")
    private List<Profesor> profesores;

}
