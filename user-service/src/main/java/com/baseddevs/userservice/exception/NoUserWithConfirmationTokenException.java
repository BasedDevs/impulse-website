package com.baseddevs.userservice.exception;

public class NoUserWithConfirmationTokenException extends RuntimeException {
    public NoUserWithConfirmationTokenException(String message) {
        super(message);
    }
}
