package com.quake.model;

import java.util.List;

public class Game {

    private Long gameId;
    private List<Player> kills;
    private int totalKills;
    private List<String> players;

    public Game(Long gameId, List<Player> playersKill, int totalKills, List<String> players) {
        this.gameId = gameId;
        this.kills = playersKill;
        this.players = players;
        this.totalKills = totalKills;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public List<Player> getKills() {
        return kills;
    }

    public void setKills(List<Player> kills) {
        this.kills = kills;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", kills=" + kills + ", totalKills=" + totalKills + ", players=" + players + '}';
    }

}
