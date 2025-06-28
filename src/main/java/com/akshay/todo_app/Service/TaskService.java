package com.akshay.todo_app.Service;

import com.akshay.todo_app.model.Task;
import com.akshay.todo_app.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
   private final  TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public  List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task addTask(String title){
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        return repo.save(task);
    }

    public Task save(Task task){
        return repo.save(task);
    }

    public void deleteTask(Long id){
         repo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task= repo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
        task.setCompleted(!task.isCompleted());
        repo.save(task);
    }
}
