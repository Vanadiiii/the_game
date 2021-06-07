package miv.adventure.thegame.domain.repository;

import miv.adventure.thegame.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    List<Question> findAllByRoundId(UUID roundId);
}
