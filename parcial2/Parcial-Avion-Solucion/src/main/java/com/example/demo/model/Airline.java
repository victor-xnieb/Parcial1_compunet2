package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@Entity 
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Table (name = "airlines")
public class Airline {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;


    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "country")
    private String country;

    @Column (name = "iata_code")
    private String iataCode;

    @OneToMany (mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airplane> airplanes  = new ArrayList<>();

}
