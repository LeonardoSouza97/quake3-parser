package com.quake.model;

public class Player {

    private String name;
    private int kills;

    public Player(String nome, int kills) {
        this.name = nome;
        this.kills = kills;
    }

    public Player() {
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills += kills;
    }

    @Override
    public String toString() {
        return "Player{" + "nome=" + name + ", kills=" + kills + '}';
    }

}
