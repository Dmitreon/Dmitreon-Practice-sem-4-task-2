package com.example.taskmanager.initializer;

import com.example.taskmanager.composite.Task;
import com.example.taskmanager.composite.TaskFactory;
import com.example.taskmanager.composite.impl.TaskFactoryImpl;
import com.example.taskmanager.exceptions.TaskCreationException;
import com.example.taskmanager.exceptions.TaskInitializationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskInitializer {
    private static final String TASK_DELIMITER = ",";
    private TaskFactory taskFactory = new TaskFactoryImpl();

    public List<Task> initializeTasks(String filePath) throws TaskInitializationException {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(TASK_DELIMITER);
                if (parts.length == 2) {
                    try {
                        tasks.add(taskFactory.createTask(parts[0], parts[1]));
                    } catch (TaskCreationException e) {
                        throw new TaskInitializationException("Failed to create task: " + line, e);
                    }
                } else {
                    throw new TaskInitializationException("Invalid task format: " + line);
                }
            }
        } catch (IOException e) {
            throw new TaskInitializationException("Error reading tasks file", e);
        }
        return tasks;
    }
}
