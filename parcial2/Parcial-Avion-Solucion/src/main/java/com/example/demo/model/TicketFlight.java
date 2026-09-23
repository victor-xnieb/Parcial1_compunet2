package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table (name = "ticket_flights")
public class TicketFlight {

    @EmbeddedId 
    private TicketFlightId id;

    @Column (name = "segment_order")
    private Integer segmentOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId ("ticketId")
    @JoinColumn(name = "ticket_id", nullable = false)
    @JsonIgnoreProperties (value = "ticketFlights")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId ("flightId")
    @JoinColumn(name = "flight_id", nullable = false)
    @JsonIgnoreProperties (value = "ticketFlights")
    private Flight flight;

    public TicketFlight(Ticket ticket, Flight flight) {
        this.ticket = ticket;
        this.flight = flight;
        this.id = new TicketFlightId(ticket.getId(), flight.getId());
    }

    

}
