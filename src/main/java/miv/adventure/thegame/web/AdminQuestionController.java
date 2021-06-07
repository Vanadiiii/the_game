package miv.adventure.thegame.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miv.adventure.thegame.domain.entity.Round;
import miv.adventure.thegame.services.RoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/rounds")
@RequiredArgsConstructor
public class AdminQuestionController {
    private final RoundService roundService;

    @GetMapping()
    public ResponseEntity<List<Round>> getAllGameRounds(@RequestParam UUID gameId) {
        log.trace("getting all rounds of game - {}", gameId);
        return ResponseEntity.ok(roundService.getGameRounds(gameId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getRoundById(@PathVariable UUID id) {
        log.trace("getting round by id - {}", id);
        return ResponseEntity.ok(roundService.getRound(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Round> updateRound(@PathVariable UUID id, @RequestBody Round round) {
        log.trace("updating round with id - {}, by body - {}", id, round);
        return ResponseEntity.ok(roundService.updateRound(id, round));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable UUID id) {
        log.trace("removing round with id - {}", id);
        roundService.deleteRound(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<UUID> createRound(@RequestBody Round round) {
        log.trace("creating new round - {}", round);
        return ResponseEntity.ok(roundService.createRound(round));
    }
}
