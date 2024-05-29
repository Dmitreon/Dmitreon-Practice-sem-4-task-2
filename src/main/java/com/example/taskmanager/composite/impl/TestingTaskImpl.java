package com.example.taskmanager.composite.impl;

import com.example.taskmanager.composite.Task;

public class TestingTaskImpl implements Task {
    private String name;
    private String status;

    public TestingTaskImpl(String name) {
        this.name = name;
        this.status = "new";
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
        System.out.println("Executing testing task: " + name);
    }
}
