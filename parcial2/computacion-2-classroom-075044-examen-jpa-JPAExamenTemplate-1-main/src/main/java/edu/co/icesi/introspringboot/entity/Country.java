package edu.co.icesi.introspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String code;
    private String confederation;

    @JsonIgnore
    @OneToMany(mappedBy = "homeCountry")
    private List<Match> homeMatches;

    @JsonIgnore
    @OneToMany(mappedBy = "awayCountry")
    private List<Match> awayMatches;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Player> players;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Club> clubs;

    public Country() {
    }

    public Country(String name, String code, String confederation) {
        this.name = name;
        this.code = code;
        this.confederation = confederation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getConfederation() { return confederation; }
    public void setConfederation(String confederation) { this.confederation = confederation; }

    public List<Match> getHomeMatches() { return homeMatches; }
    public void setHomeMatches(List<Match> homeMatches) { this.homeMatches = homeMatches; }

    public List<Match> getAwayMatches() { return awayMatches; }
    public void setAwayMatches(List<Match> awayMatches) { this.awayMatches = awayMatches; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }

    public List<Club> getClubs() { return clubs; }
    public void setClubs(List<Club> clubs) { this.clubs = clubs; }
}
