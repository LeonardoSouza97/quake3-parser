package com.quake.controller;

import com.quake.model.Game;
import com.quake.model.Player;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parser.Parser;

public class ParserController {

    final static String pathLog = "/home/developer/Projetos/quake3-parser/log/games.log";
    private static List<Game> games;

    public static List<Game> ranking() {
        System.out.println("RANKING POR GAME");

        games.stream().forEach(game -> {
            Collections.sort(game.getKills());
            System.out.println("GAME ID:" + game.getGameId() + " Players Ranking:" + game.getKills());
        });
        
        return games;
    }

    public static List<Game> parser() {
        String result, playerKill, playerDeath = "";
        Long contGame = 1l;
        List<Player> players = new ArrayList<>();
        List<String> namePlayers = new ArrayList<>();
        games = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathLog));

            while (br.ready()) {
                String linha = br.readLine();

                if (linha.contains("InitGame")) {
                    int totalKills = 0;
                    do {
                        if (linha.contains("Kill")) {
                            result = linha.split(":")[3];
                            playerKill = result.split("killed")[0];
                            playerDeath = result.split("killed")[1];
                            playerDeath = playerDeath.split("by")[0];

                            if (playerKill.contains("<world>")) {
                                addPlayer(players, namePlayers, playerDeath, "death");
                            } else {
                                addPlayer(players, namePlayers, playerKill, "kill");
                            }
                        }

                        totalKills++;
                        linha = br.readLine();

                    } while (!linha.contains("ShutdownGame"));

                    games.add(new Game(contGame, players, totalKills, namePlayers));

                    namePlayers = new ArrayList<>();
                    players = new ArrayList<>();
                    contGame++;
                    totalKills = 0;
                };

            }

            //IMPRIMINDO O RELATÓRIO FINAL
            games.stream().forEach(game -> {
                System.out.println("GAME: " + game);
            });

            return games;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();

    }

    public static boolean containsName(final List<Player> list, final String name) {
        return list.stream().filter(o -> o.getNome().equals(name)).findFirst().isPresent();
    }

    public static Player containsPlayer(final List<Player> list, final String name) {
        return list.stream().filter(o -> o.getNome().equals(name)).findFirst().get();
    }

    public static void addPlayer(List<Player> listPlayersKill, List<String> listPlayers, String namePlayer, String action) {

        switch (action) {

            case "death":
                if (!containsName(listPlayersKill, namePlayer)) {
                    listPlayersKill.add(new Player(namePlayer, 0));
                    listPlayers.add(namePlayer);
                } else {
                    Player player = containsPlayer(listPlayersKill, namePlayer);
                    player.setKills(-1);
                }
                break;
            case "kill":
                if (!containsName(listPlayersKill, namePlayer)) {
                    listPlayersKill.add(new Player(namePlayer, 0));
                    listPlayers.add(namePlayer);
                } else {
                    Player player = containsPlayer(listPlayersKill, namePlayer);
                    player.setKills(1);
                }
                break;
        }

    }

}
