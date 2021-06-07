package miv.adventure.thegame.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miv.adventure.thegame.domain.entity.Round;
import miv.adventure.thegame.domain.repository.RoundRepository;
import miv.adventure.thegame.exceptions.NoSuchRoundException;
import miv.adventure.thegame.services.RoundService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {
    private final RoundRepository roundRepository;


    @Override
    public List<Round> getGameRounds(UUID gameId) {
        return roundRepository.findAllByGameId(gameId);
    }

    @Override
    public Round getRound(UUID id) {
        return roundRepository
                .findById(id)
                .orElseThrow(() -> NoSuchRoundException.of(id));
    }
}
