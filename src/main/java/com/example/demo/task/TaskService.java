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
    public void updateTask(Long taskId, String name, String description, String importance, boolean finished) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task with id " + taskId + " does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(task.getName(), name)) {
            task.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(task.getDescription(), description)) {
            task.setDescription(description);
        }

        if (importance != null && importance.length() > 0 && !Objects.equals(task.getImportance(), importance)) {
            task.setImportance(importance);
        }

        if (finished == true || finished == false) {
            if (!Objects.equals(task.isFinished(), finished)) {
                task.setFinished(finished);
            }
        }

    }
}
