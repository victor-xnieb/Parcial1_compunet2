package edu.co.icesi.introspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String position;

    @Column(name = "fifa_score")
    private Integer fifaScore;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private List<PlayerClub> playerClubs;

    public Player(String name, LocalDate birthDate, String position, Integer fifaScore, Country country) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.fifaScore = fifaScore;
        this.country = country;
    }


}
