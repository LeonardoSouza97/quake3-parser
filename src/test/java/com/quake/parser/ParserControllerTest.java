package com.quake.parser;

import com.quake.controller.ParserController;
import com.quake.model.Game;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class ParserControllerTest {

    private ParserController parserController;

    @Before
    public void setUp() {
        this.parserController = new ParserController();
    }

    @Test
    public void parserNumberOfGamesSuccessTest() {
        List<Game> games = parserController.parser();

        assertEquals(20, games.size());
    }

    @Test
    public void parserNumberOfGamesFailedTest() {
        List<Game> games = parserController.parser();

        assertNotEquals(35, games.size());
    }

    @Test
    public void rankingTest() {
        List<Game> gamesRanking = parserController.ranking();

        assertNotEquals(35, gamesRanking.size());
    }

    @Test
    public void rankingNumberOfGamesSuccessTest() {
        List<Game> gamesRanking = parserController.ranking();

        assertEquals(20, gamesRanking.size());
    }
}
