package com.example.taskmanager.composite;

import com.example.taskmanager.exceptions.TaskCreationException;

public interface TaskFactory {
    Task createTask(String type, String name) throws TaskCreationException;
}
