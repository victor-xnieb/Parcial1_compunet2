package com.example.demo.model;

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
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "passenger_full_name")
    private String passengerFullName;

    @Column (name = "booking_code")
    private String bookingCode;

    @Column (name = "purchase_date")
    private Timestamp purchaseDate;

    @ManyToOne 
    @JoinColumn(name = "origin_airport_id", nullable = false)
    @JsonIgnoreProperties (value = "")
    private Airport originAirport;

    @ManyToOne 
    @JoinColumn(name = "destination_airport_id", nullable = false)
    @JsonIgnoreProperties (value = "")
    private Airport destinationAirport;


    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketFlight> ticketFlights = new ArrayList<>();
}
