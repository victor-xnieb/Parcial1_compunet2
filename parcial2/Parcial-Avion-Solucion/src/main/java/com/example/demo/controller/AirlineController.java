package com.example.demo.controller;

import com.example.demo.model.Airline;
import com.example.demo.model.Airplane;
import com.example.demo.repository.IAirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor
public class AirlineController {


    private final IAirlineRepository airlineRepository;

    @GetMapping
    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll();
    }


    @GetMapping ("/consulta1")
    public List<Airline> consulta1() {
        return airlineRepository.findByAirplanes_Flights_OriginAirport_NameAndAirplanes_Flights_DestinationAirport_Name("El Dorado", "JFK");
    }

    @GetMapping ("/consulta3")
    public List<Airline> consulta3() {
        return airlineRepository.findDistinctByAirplanes_Flights_OriginAirport_CityOrAirplanes_Flights_DestinationAirport_City("Bogota", "Bogota");
    }

    @GetMapping ("/consulta4")
    public List<Airline> consulta4(){
        
        return airlineRepository.findByAirplanes_Flights_DestinationAirport_NameAndAirplanes_Flights_ArrivalDateBetween("El Dorado", Timestamp.valueOf("2026-03-01 00:00:00"), Timestamp.valueOf("2026-03-11 23:59:59 "));
    }

}
