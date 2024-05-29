package com.example.taskmanager.exceptions;

public class TaskCreationException extends Exception {
    public TaskCreationException(String message) {
        super(message);
    }

    public TaskCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
