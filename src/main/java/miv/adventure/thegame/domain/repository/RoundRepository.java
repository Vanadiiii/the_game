package miv.adventure.thegame.domain.repository;

import miv.adventure.thegame.domain.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoundRepository extends JpaRepository<Round, UUID> {
    List<Round> findAllByGameId(UUID gameId);
}
