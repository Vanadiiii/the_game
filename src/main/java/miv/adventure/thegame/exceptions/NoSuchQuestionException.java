package miv.adventure.thegame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchQuestionException extends RuntimeException {
    public NoSuchQuestionException(String message) {
        super(message);
    }

    public static NoSuchQuestionException of(UUID id) {
        return new NoSuchQuestionException("There are no such question with id - " + id);
    }
}
