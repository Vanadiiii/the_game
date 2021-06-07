package miv.adventure.thegame.services;

import miv.adventure.thegame.domain.entity.Game;
import miv.adventure.thegame.domain.repository.GameRepository;
import miv.adventure.thegame.services.impl.GameServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {
    @InjectMocks
    private GameServiceImpl adminService;
    @Mock
    private GameRepository gameRepository;

    private final EasyRandom random = new EasyRandom();

    @Test
    void getGameTest() {
        int size = 10;
        when(gameRepository.findAll())
                .thenReturn(
                        Stream.generate(() -> random.nextObject(Game.class))
                                .limit(size)
                                .collect(Collectors.toList())
                );

        List<Game> games = adminService.getGames();

        assertEquals(size, games.size());
    }

    @Test
    void createGameTest() {
        Game game = random.nextObject(Game.class);
        UUID gameId = UUID.randomUUID();

        when(gameRepository.saveAndFlush(game))
                .thenAnswer(invocation -> {
                    Game game1 = invocation.getArgument(0);
                    game1.setId(gameId);
                    return game1;
                });

        UUID savedGameId = adminService.createGame(game);

        assertEquals(gameId, savedGameId);
    }

    @Test
    void getGameByIdTest() {
        Game game = random.nextObject(Game.class);
        UUID gameId = game.getId();

        when(gameRepository.findById(gameId))
                .thenReturn(Optional.of(game));

        Game savedGame = adminService.getGameById(gameId);

        assertEquals(savedGame, game);
    }

    @Test
    void updateGameTest() {
        Game newGame = random.nextObject(Game.class);
        Game savedGame = random.nextObject(Game.class);
        UUID savedGameId = savedGame.getId();

        when(gameRepository.findById(savedGameId))
                .thenReturn(Optional.of(savedGame));
        when(gameRepository.saveAndFlush(any()))
                .thenReturn(newGame);

        Game game = adminService.updateGame(savedGameId, newGame);

        assertEquals(savedGameId, game.getId());
    }

    @Test
    void deleteGameTest() {
        Game savedGame = random.nextObject(Game.class);
        UUID savedGameId = savedGame.getId();

        doNothing()
                .when(gameRepository)
                .deleteById(eq(savedGameId));

        assertDoesNotThrow(() -> adminService.deleteGame(savedGameId));
    }
}