package com.example.task_manager.servico;

import com.example.task_manager.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks;

    public TaskService(){
        tasks = new ArrayList();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {

        return tasks.stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public void createTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(Long id, Task taskDetails) {
        tasks.forEach(task -> {
            if (task.getId() == id) {
                task.setTitle(taskDetails.getTitle());
                task.setDescription(taskDetails.getDescription());
                task.setCompleted(taskDetails.isCompleted());
            }
        });
    }

    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
