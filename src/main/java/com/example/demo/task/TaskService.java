package com.example.demo.task;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
        System.out.println(task);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("Task with id " + taskId + " does not exists");
        }
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Long taskId, Task newTask) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task with id " + taskId + " does not exists"));

        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setImportance(newTask.getImportance());
        task.setFinished(newTask.isFinished());

    }

}
