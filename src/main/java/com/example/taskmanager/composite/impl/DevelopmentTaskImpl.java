package com.example.taskmanager.composite.impl;

import com.example.taskmanager.composite.Task;

public class DevelopmentTaskImpl implements Task {
    private String name;
    private String status;

    public DevelopmentTaskImpl(String name) {
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
        System.out.println("Executing development task: " + name);
    }
}
