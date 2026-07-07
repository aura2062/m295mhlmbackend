package com.example.mhlmbackend.exception;

public class ArmorLoadoutNotFoundException extends RuntimeException {
    public ArmorLoadoutNotFoundException(String id) {
        super("An ArmorLoadout with id: " + id + " does not exist currently");
    }
}
