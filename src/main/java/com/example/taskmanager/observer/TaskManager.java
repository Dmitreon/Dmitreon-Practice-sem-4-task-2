package com.example.taskmanager.observer;

import com.example.taskmanager.composite.Task;

public interface TaskManager {
    void addObserver(Observer observer);
    void addObserverToTask(Observer observer, Task task);
    void removeObserver(Observer observer);
    void notifyObservers(Task task);
}
