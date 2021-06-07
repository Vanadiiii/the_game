package miv.adventure.thegame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There are no round with this id")
public class NoSuchRoundException extends RuntimeException {
    public NoSuchRoundException(String message) {
        super(message);
    }

    public static NoSuchGameException of(UUID id) {
        return new NoSuchGameException("There are no such round with id - " + id);
    }
}
