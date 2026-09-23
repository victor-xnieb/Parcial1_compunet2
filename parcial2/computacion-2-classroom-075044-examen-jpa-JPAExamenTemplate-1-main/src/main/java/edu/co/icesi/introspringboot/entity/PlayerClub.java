package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "player_club")
public class PlayerClub {

    @EmbeddedId
    private PlayerClubId id;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public PlayerClub() {
    }

    public PlayerClub(Player player, Club club, LocalDate startDate, LocalDate endDate) {
        this.player = player;
        this.club = club;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = new PlayerClubId(player.getId(), club.getId());
    }

    public PlayerClubId getId() {
        return id;
    }

    public void setId(PlayerClubId id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
