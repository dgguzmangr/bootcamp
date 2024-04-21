package com.pragma.bootcamp.domain.exception;

public class MaxDescCharactersException extends RuntimeException{
    public MaxDescCharactersException(String message) {
        super(message);
    }
}
