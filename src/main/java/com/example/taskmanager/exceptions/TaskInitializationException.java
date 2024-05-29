package com.example.taskmanager.exceptions;

public class TaskInitializationException extends Exception {
    public TaskInitializationException(String message) {
        super(message);
    }

    public TaskInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
