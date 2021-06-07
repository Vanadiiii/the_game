package miv.adventure.thegame.services;

import miv.adventure.thegame.domain.entity.Game;

import java.util.List;
import java.util.UUID;

public interface GameService {
    List<Game> getGames();

    UUID createGame(Game game);

    Game getGameById(UUID id);

    Game updateGame(UUID id, Game game);

    void deleteGame(UUID id);
}
