package com.quake.parser;

import com.quake.model.Game;
import com.quake.model.Player;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = new Game();
    }

    @Test
    public void testGetSetGameNull() {
        game = new Game(null, null, 0, null);
        assertNull(game.getGameId());
    }

    @Test
    public void testGetSetGameWithContent() {
        List<Player> listPlayers = new ArrayList<>();
        List<String> listPlayersNames = new ArrayList<>();
        listPlayersNames.add("João");
        Player player = new Player("Leonardo", 10);
        listPlayers.add(player);

        Long expectedId = 32l;
        game = new Game(32l, listPlayers, 0, listPlayersNames);

        assertEquals(expectedId, game.getGameId());
    }

    @Test
    public void testGetSetGameWithContentEmpty() {
        List<Player> listPlayers = new ArrayList<>();
        List<String> listPlayersNames = new ArrayList<>();

        game = new Game(0l, listPlayers, 0, listPlayersNames);

        assertEquals(0l, game.getKills().size());
        assertEquals(0l, game.getPlayers().size());
        assertEquals(0, game.getTotalKills());
    }
}
