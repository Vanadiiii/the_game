package miv.adventure.thegame.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miv.adventure.thegame.domain.entity.Round;
import miv.adventure.thegame.domain.repository.RoundRepository;
import miv.adventure.thegame.exceptions.NoSuchRoundException;
import miv.adventure.thegame.services.RoundService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public UUID createRound(Round round) {
        return roundRepository
                .saveAndFlush(round)
                .getId();
    }

    @Override
    public void deleteRound(UUID id) {
        roundRepository
                .deleteById(id);
    }

    @Override
    @Transactional
    public Round updateRound(UUID id, Round round) {
        round.setId(id);
        roundRepository.deleteById(id);
        roundRepository.saveAndFlush(round);
        return round;
    }


}
