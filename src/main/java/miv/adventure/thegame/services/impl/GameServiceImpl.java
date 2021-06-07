package miv.adventure.thegame.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miv.adventure.thegame.domain.entity.Game;
import miv.adventure.thegame.domain.repository.GameRepository;
import miv.adventure.thegame.exceptions.NoSuchGameException;
import miv.adventure.thegame.services.GameService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public UUID createGame(Game game) {
        UUID gameId = UUID.randomUUID();
        game.setId(gameId);
        return gameRepository
                .saveAndFlush(game)
                .getId();
    }

    @Override
    public Game getGameById(UUID id) {
        return gameRepository
                .findById(id)
                .orElseThrow(() -> NoSuchGameException.of(id));
    }

    @Override
    @Transactional
    public Game updateGame(UUID id, Game game) {
        game.setId(id);
        Game savedGame = getGameById(id);
        gameRepository.delete(savedGame);
        gameRepository.saveAndFlush(game);
        return game;
    }

    @Override
    public void deleteGame(UUID id) {
        gameRepository.deleteById(id);
    }
}
