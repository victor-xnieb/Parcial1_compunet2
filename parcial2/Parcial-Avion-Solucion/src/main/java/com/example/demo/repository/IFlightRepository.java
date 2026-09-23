package com.example.demo.repository;

import com.example.demo.model.Airport;
import com.example.demo.model.Flight;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findTop5ByArrivalDateBetweenOrderByEstimatedPassengersDesc(Timestamp min,Timestamp mx);
}
