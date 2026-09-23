package com.example.demo.repository;

import com.example.demo.model.Airline;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirlineRepository extends JpaRepository<Airline, Long> {


    List<Airline> findByAirplanes_Flights_OriginAirport_NameAndAirplanes_Flights_DestinationAirport_Name(String origin, String destination);
    List<Airline> findDistinctByAirplanes_Flights_OriginAirport_CityOrAirplanes_Flights_DestinationAirport_City(String originCity, String arriveCity);
    List<Airline> findByAirplanes_Flights_DestinationAirport_NameAndAirplanes_Flights_ArrivalDateBetween(String name, Timestamp min, Timestamp max);

}
