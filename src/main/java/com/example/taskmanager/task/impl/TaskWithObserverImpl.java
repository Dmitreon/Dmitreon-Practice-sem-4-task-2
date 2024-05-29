package com.example.taskmanager.task.impl;

import com.example.taskmanager.composite.Task;
import com.example.taskmanager.observer.TaskManager;
import com.example.taskmanager.task.TaskWithObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskWithObserverImpl implements TaskWithObserver {
    private static final Logger logger = LogManager.getLogger(TaskWithObserverImpl.class);
    private String name;
    private String status;
    private TaskManager manager;

    public TaskWithObserverImpl(String name, TaskManager manager) {
        this.name = name;
        this.status = "new";
        this.manager = manager;
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
        manager.notifyObservers(this);
        logger.info("Task " + name + " status changed to " + status);
    }

    @Override
    public void execute() {
        logger.info("Executing task with observer: " + name);
    }
}
