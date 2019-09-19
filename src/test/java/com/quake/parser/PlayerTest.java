package com.quake.parser;

import com.quake.model.Player;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    
    private Player player;

    @Before
    public void setUp() {
        this.player = new Player();
    }

    @Test
    public void testGetSetPlayerNull() {
        player = new Player(null, 0);
        assertNull(player.getNome());
    }

    @Test
    public void testGetSetPlayerWithContent() {
        player = new Player("Leonardo", 10);

        assertEquals(10, player.getKills());
        assertEquals("Leonardo", player.getNome());
    }

    @Test
    public void testGetSetPlayerWithContentEmpty() {
        player = new Player("", 0);

        assertEquals("", player.getNome());
        assertEquals(0, player.getKills());
    }
}
