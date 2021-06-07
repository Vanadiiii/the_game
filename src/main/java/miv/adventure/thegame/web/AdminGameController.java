package miv.adventure.thegame.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miv.adventure.thegame.domain.entity.Game;
import miv.adventure.thegame.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/games")
@RequiredArgsConstructor
public class AdminGameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<Collection<Game>> getAllGames() {
        log.trace("getting all games");
        return ResponseEntity.ok(gameService.getGames());
    }

    @PostMapping
    public ResponseEntity<UUID> createGame(@RequestBody Game game) {
        log.trace("creating new game - {}", game);
        return ResponseEntity.ok(gameService.createGame(game));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable UUID id) {
        log.trace("getting game by id - {}", id);
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable UUID id, @RequestBody Game game) {
        log.trace("updating game with id - {}, by body - {}", id, game);
        return ResponseEntity.ok(gameService.updateGame(id, game));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable UUID id) {
        log.trace("removing game with id - {}", id);
        gameService.deleteGame(id);
        return ResponseEntity.ok().build();
    }
}
