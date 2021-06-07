package miv.adventure.thegame.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miv.adventure.thegame.domain.entity.Question;
import miv.adventure.thegame.domain.repository.QuestionRepository;
import miv.adventure.thegame.exceptions.NoSuchQuestionException;
import miv.adventure.thegame.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getRoundQuestions(UUID roundId) {
        return questionRepository
                .findAllByRoundId(roundId);
    }

    @Override
    public Question getQuestion(UUID id) {
        return questionRepository
                .findById(id)
                .orElseThrow(() -> NoSuchQuestionException.of(id));
    }

    @Override
    public UUID createQuestion(Question question) {
        UUID questionId = UUID.randomUUID();
        question.setId(questionId);
        return questionRepository
                .saveAndFlush(question)
                .getId();
    }

    @Override
    public void deleteQuestion(UUID id) {
        questionRepository
                .deleteById(id);
    }

    @Override
    public Question updateQuestion(UUID id, Question question) {
        question.setId(id);
        questionRepository.deleteById(id);
        questionRepository.saveAndFlush(question);
        return question;
    }
}
