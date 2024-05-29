package com.example.taskmanager.observer.impl;

import com.example.taskmanager.composite.Task;
import com.example.taskmanager.observer.Observer;
import com.example.taskmanager.observer.TaskManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerImpl implements TaskManager {
    private List<Observer> globalObservers = new ArrayList<>();
    private Map<Task, List<Observer>> taskObservers = new HashMap<>();

    @Override
    public void addObserver(Observer observer) {
        globalObservers.add(observer);
    }

    @Override
    public void addObserverToTask(Observer observer, Task task) {
        taskObservers.computeIfAbsent(task, k -> new ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        globalObservers.remove(observer);
        for (List<Observer> observers : taskObservers.values()) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(Task task) {
        for (Observer observer : globalObservers) {
            observer.update(task);
        }
        List<Observer> specificObservers = taskObservers.get(task);
        if (specificObservers != null) {
            for (Observer observer : specificObservers) {
                observer.update(task);
            }
        }
    }
}
