package miv.adventure.thegame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There are no such game")
public class NoSuchGameException extends RuntimeException {
    public NoSuchGameException(String message) {
        super(message);
    }

    public static NoSuchGameException of(UUID id) {
        return new NoSuchGameException("No such game with id - " + id);
    }
}
