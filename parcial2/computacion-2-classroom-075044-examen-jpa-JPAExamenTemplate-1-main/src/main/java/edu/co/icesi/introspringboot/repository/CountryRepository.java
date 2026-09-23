package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Country;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    /**
     * Top 10 de países con mejores jugadores acorde al score del jugador.
     * Navegación: Country -> players -> fifaScore
     * Se usa Distinct para no repetir el país si tiene varios jugadores en el top.
     * Se usa Top10 para limitar el resultado.
     */
    // 5
    List<Country> findTop6ByOrderByPlayers_FifaScoreDesc();

    @Query(value = """
        SELECT c.* FROM country c
        JOIN (
            SELECT country_id, MAX(fifa_score) AS max_score,
                RANK() OVER (ORDER BY MAX(fifa_score) DESC) AS posicion
            FROM player
            GROUP BY country_id
        ) ranking ON ranking.country_id = c.id
        WHERE ranking.posicion <= 5
        ORDER BY ranking.max_score DESC
        """, nativeQuery = true)
    List<Country> top5PaisesPorMejorJugadorConEmpates();
}
