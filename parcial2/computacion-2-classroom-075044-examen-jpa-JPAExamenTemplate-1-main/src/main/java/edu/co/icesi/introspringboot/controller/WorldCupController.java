package edu.co.icesi.introspringboot.controller;

import edu.co.icesi.introspringboot.entity.Club;
import edu.co.icesi.introspringboot.entity.Country;
import edu.co.icesi.introspringboot.entity.Match;
import edu.co.icesi.introspringboot.entity.Player;
import edu.co.icesi.introspringboot.repository.ClubRepository;
import edu.co.icesi.introspringboot.repository.CountryRepository;
import edu.co.icesi.introspringboot.repository.MatchRepository;
import edu.co.icesi.introspringboot.repository.PlayerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worldcup")
public class WorldCupController {

    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final ClubRepository clubRepository;
    private final CountryRepository countryRepository;


    public WorldCupController(PlayerRepository playerRepository,
                              MatchRepository matchRepository,
                              ClubRepository clubRepository,
                              CountryRepository countryRepository
                              ) {
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.clubRepository = clubRepository;
        this.countryRepository = countryRepository;
    }

    //Jugadores que han jigado en el real
    @GetMapping("/ej1")
    public List<Player> ej1(){
        return  playerRepository.findByPlayerClubs_Club_Name("Real Madrid");
    }

    @GetMapping ("/ej2") 
    public List<Player> ej2() {
        return playerRepository.findByCountry_NameAndPlayerClubs_Club_Name("Colombia", "Bayern Munich");
    }

    @GetMapping ("/ej3")
    public List<Match> ej3(){
        return matchRepository.findDistinctByHomeCountry_Players_PlayerClubs_Club_Name("Bayern Munich");
    }

    @GetMapping ("/ej4")
    public List<Club> ej4() {
        return clubRepository.findDistinctByPlayerClubs_Player_Country_HomeMatches_IdOrPlayerClubs_Player_Country_AwayMatches_Id(70, 70);
    }

    @GetMapping ("/ej5")
    public List<Country> ej5() {
        return countryRepository.findTop6ByOrderByPlayers_FifaScoreDesc();
    }


}
