package com.example.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column (name = "flight_number")
    private String flightNumber;

    @Column (name = "departure_date")
    private Timestamp departureDate;

    @Column (name = "arrival_date")
    private Timestamp arrivalDate;


    @Column (name = "estimated_passengers")
    private Integer estimatedPassengers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id", nullable = false)
    @JsonIgnoreProperties (value = "flights")
    private Airplane airplane;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_airport_id", nullable = false)
    @JsonIgnoreProperties (value = "departingFlights")
    private Airport originAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_airport_id", nullable = false)
    @JsonIgnoreProperties (value = "destinationFlights")
    private Airport destinationAirport;

    @JsonIgnore 
    @OneToMany (mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<TicketFlight> ticketFlights = new ArrayList<>();
}
