package com.example.taskmanager.repository;

import com.example.taskmanager.composite.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepositoryImpl implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public List<Task> findTasksByName(String name) {
        return tasks.stream()
                .filter(task -> task.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public void sortTasks() {
        tasks.sort(Comparator.comparing(Task::getName));
    }
}
