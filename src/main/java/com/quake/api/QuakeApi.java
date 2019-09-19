package com.quake.api;

import com.quake.controller.ParserController;
import com.quake.model.Game;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/game")
public class QuakeApi {

    private ParserController parserController;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> findGameById(@PathVariable("id") Long id) {
        List<Game> games = parserController.parser();

        Game gameById = games.stream().filter(game -> game.getGameId().equals(id)).findFirst().orElse(null);

        if (gameById != null) {
            return new ResponseEntity<>(gameById, HttpStatus.OK);
        }
        return new ResponseEntity<>("Não existe o game com esse ID", HttpStatus.NOT_FOUND);
    }
}
