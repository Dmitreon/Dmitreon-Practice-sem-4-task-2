package com.example.taskmanager.main;

import com.example.taskmanager.composite.impl.CompositeTaskImpl;
import com.example.taskmanager.observer.impl.DeveloperImpl;
import com.example.taskmanager.observer.impl.TaskManagerImpl;
import com.example.taskmanager.task.impl.TaskWithObserverImpl;
import com.example.taskmanager.initializer.TaskInitializer;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.TaskRepositoryImpl;
import com.example.taskmanager.composite.Task;
import com.example.taskmanager.exceptions.TaskInitializationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting Task Manager application");

        TaskManagerImpl manager = new TaskManagerImpl();
        DeveloperImpl dev1 = new DeveloperImpl("Alice");
        DeveloperImpl dev2 = new DeveloperImpl("Bob");

        manager.addObserver(dev1);
        manager.addObserver(dev2);

        TaskInitializer initializer = new TaskInitializer();
        TaskRepository repository = new TaskRepositoryImpl();

        URL resource = Main.class.getClassLoader().getResource("tasks.txt");
        if (resource == null) {
            logger.error("Resource not found: tasks.txt");
            return;
        }

        try {
            List<Task> tasks = initializer.initializeTasks(resource.getPath());

            CompositeTaskImpl compositeTask = new CompositeTaskImpl("Composite Task");
            compositeTask.add(tasks.get(0));
            compositeTask.add(tasks.get(1));

            Task singleTask = tasks.get(2);

            TaskWithObserverImpl compositeTaskWithObserver = new TaskWithObserverImpl(compositeTask.getName(), manager);
            TaskWithObserverImpl singleTaskWithObserver = new TaskWithObserverImpl(singleTask.getName(), manager);

            repository.addTask(compositeTaskWithObserver);
            repository.addTask(singleTaskWithObserver);

            compositeTaskWithObserver.execute();
            compositeTask.getSubtasks().get(0).setStatus("in progress");
            compositeTask.getSubtasks().get(0).setStatus("completed");
            compositeTask.getSubtasks().get(1).setStatus("in progress");

            singleTaskWithObserver.execute();
            singleTaskWithObserver.setStatus("in progress");
            singleTaskWithObserver.setStatus("completed");

        } catch (TaskInitializationException e) {
            logger.error("Error initializing tasks", e);
        }

        repository.sortTasks();
        List<Task> sortedTasks = repository.getAllTasks();
        for (Task task : sortedTasks) {
            logger.info("Sorted task: " + task.getName() + ", Status: " + task.getStatus());
            if (task instanceof CompositeTaskImpl) {
                CompositeTaskImpl composite = (CompositeTaskImpl) task;
                composite.printSubtasksStatus();
            }
        }

        logger.info("Task Manager application finished");
    }
}
