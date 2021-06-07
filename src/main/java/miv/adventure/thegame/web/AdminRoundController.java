package miv.adventure.thegame.web;

import lombok.RequiredArgsConstructor;
import miv.adventure.thegame.domain.entity.Round;
import miv.adventure.thegame.services.RoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin/rounds")
@RequiredArgsConstructor
public class AdminRoundController {
    private final RoundService roundService;

    @GetMapping()
    public ResponseEntity<List<Round>> getAllGameRounds(@RequestParam UUID gameId) {
        return ResponseEntity.ok(roundService.getGameRounds(gameId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getRoundById(@PathVariable UUID id) {
        return ResponseEntity.ok(roundService.getRound(id));
    }
}
