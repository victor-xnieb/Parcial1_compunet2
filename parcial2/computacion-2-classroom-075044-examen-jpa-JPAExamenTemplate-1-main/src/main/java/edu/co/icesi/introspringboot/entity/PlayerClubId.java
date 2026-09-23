package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Table
public class PlayerClubId implements Serializable {

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "club_id")
    private Integer clubId;

    public PlayerClubId() {
    }

    public PlayerClubId(Integer playerId, Integer clubId) {
        this.playerId = playerId;
        this.clubId = clubId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerClubId that = (PlayerClubId) o;
        return Objects.equals(playerId, that.playerId) && Objects.equals(clubId, that.clubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, clubId);
    }
}
