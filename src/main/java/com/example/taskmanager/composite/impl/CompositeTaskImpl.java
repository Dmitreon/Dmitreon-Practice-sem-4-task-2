package com.example.taskmanager.composite.impl;

import com.example.taskmanager.composite.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CompositeTaskImpl implements Task {
    private static final Logger logger = LogManager.getLogger(CompositeTaskImpl.class);
    private String name;
    private String status;
    private List<Task> subtasks = new ArrayList<>();

    public CompositeTaskImpl(String name) {
        this.name = name;
        this.status = "new";
    }

    public void add(Task task) {
        subtasks.add(task);
    }

    public void remove(Task task) {
        subtasks.remove(task);
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void execute() {
        logger.info("Executing composite task: " + name);
        for (Task task : subtasks) {
            task.execute();
        }
    }

    public void printSubtasksStatus() {
        for (Task subtask : subtasks) {
            logger.info("  - Subtask: " + subtask.getName() + ", Status: " + subtask.getStatus());
        }
    }
}
