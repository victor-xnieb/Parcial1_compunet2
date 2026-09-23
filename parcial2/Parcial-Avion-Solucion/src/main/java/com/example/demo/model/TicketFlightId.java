package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode 
public class TicketFlightId {

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column (name = "flight_id")
    private Long flightId; 
    
}
