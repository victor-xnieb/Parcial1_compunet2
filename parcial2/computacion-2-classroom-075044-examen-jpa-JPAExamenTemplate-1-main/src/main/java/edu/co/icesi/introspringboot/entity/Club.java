package edu.co.icesi.introspringboot.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city;
    private LocalDate founded;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<PlayerClub> playerClubs;



    public Club(String name, String city, LocalDate founded, Country country) {
        this.name = name;
        this.city = city;
        this.founded = founded;
        this.country = country;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public LocalDate getFounded() { return founded; }
    public void setFounded(LocalDate founded) { this.founded = founded; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public List<PlayerClub> getPlayerClubs() { return playerClubs; }
    public void setPlayerClubs(List<PlayerClub> playerClubs) { this.playerClubs = playerClubs; }
}
