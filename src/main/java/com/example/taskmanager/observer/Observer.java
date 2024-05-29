package com.example.taskmanager.observer;

import com.example.taskmanager.composite.Task;

public interface Observer {
    void update(Task task);
}
