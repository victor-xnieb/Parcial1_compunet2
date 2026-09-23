package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter 
@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "match_game")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @ManyToOne
    @JoinColumn(name = "home_country_id")
    private Country homeCountry;

    @ManyToOne
    @JoinColumn(name = "away_country_id")
    private Country awayCountry;

    private String stadium;

   
}
