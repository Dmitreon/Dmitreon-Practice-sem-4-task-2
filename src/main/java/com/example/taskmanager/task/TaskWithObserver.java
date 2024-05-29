package com.example.taskmanager.task;

import com.example.taskmanager.composite.Task;

public interface TaskWithObserver extends Task {
    void setStatus(String status);
}
