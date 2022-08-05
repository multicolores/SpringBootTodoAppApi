package com.example.demo.task;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    private Long id;
    private String name;
    private String description;
    private boolean finished;
    private String importance;

    public Task() {

    }

    public Task(Long id, String name, String description, boolean finished, String importance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.finished = finished;
        this.importance = importance;
    }

    public Task(String name, String description, boolean finished, String importance) {
        this.name = name;
        this.description = description;
        this.finished = finished;
        this.importance = importance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", finished=" + finished + ", id=" + id + ", importance="
                + importance + ", name=" + name + "]";
    }

}
