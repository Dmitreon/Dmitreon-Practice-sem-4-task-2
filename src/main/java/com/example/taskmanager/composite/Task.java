package com.example.taskmanager.composite;

public interface Task {
    String getName();
    String getStatus();
    void setStatus(String status);
    void execute();
}
