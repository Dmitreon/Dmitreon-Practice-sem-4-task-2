package com.example.taskmanager.repository;

import com.example.taskmanager.composite.Task;

import java.util.List;

public interface TaskRepository {
    void addTask(Task task);
    List<Task> getAllTasks();
    List<Task> findTasksByName(String name);
    void sortTasks();
}
