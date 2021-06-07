package miv.adventure.thegame.services;

import miv.adventure.thegame.domain.entity.Round;

import java.util.List;
import java.util.UUID;

public interface RoundService {
    List<Round> getGameRounds(UUID gameId);

    Round getRound(UUID id);

    UUID createRound(Round round);

    void deleteRound(UUID id);

    Round updateRound(UUID id, Round round);
}
