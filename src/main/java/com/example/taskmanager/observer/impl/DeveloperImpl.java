package com.example.taskmanager.observer.impl;

import com.example.taskmanager.composite.Task;
import com.example.taskmanager.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeveloperImpl implements Observer {
    private static final Logger logger = LogManager.getLogger(DeveloperImpl.class);
    private String name;

    public DeveloperImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(Task task) {
        logger.info("Developer " + name + " notified of task change: " + task.getName() + " is now " + task.getStatus());
    }
}
