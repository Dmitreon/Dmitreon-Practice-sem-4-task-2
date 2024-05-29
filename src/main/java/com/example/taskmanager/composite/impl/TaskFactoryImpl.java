package com.example.taskmanager.composite.impl;

import com.example.taskmanager.composite.Task;
import com.example.taskmanager.composite.TaskFactory;
import com.example.taskmanager.exceptions.TaskCreationException;

public class TaskFactoryImpl implements TaskFactory {
    @Override
    public Task createTask(String type, String name) throws TaskCreationException {
        switch (type.toLowerCase()) {
            case "development":
                return new DevelopmentTaskImpl(name);
            case "testing":
                return new TestingTaskImpl(name);
            case "design":
                return new DesignTaskImpl(name);
            default:
                throw new TaskCreationException("Unknown task type: " + type);
        }
    }
}
