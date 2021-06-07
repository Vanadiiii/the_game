package miv.adventure.thegame.services;

import miv.adventure.thegame.domain.entity.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionService {
    List<Question> getRoundQuestions(UUID gameId);

    Question getQuestion(UUID id);

    UUID createQuestion(Question round);

    void deleteQuestion(UUID id);

    Question updateQuestion(UUID id, Question round);
}
