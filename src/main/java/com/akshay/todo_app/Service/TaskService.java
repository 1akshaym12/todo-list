package com.akshay.todo_app.Service;

import com.akshay.todo_app.model.Task;
import com.akshay.todo_app.model.User;
import com.akshay.todo_app.repo.TaskRepository;
import com.akshay.todo_app.repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;
@Service
public class TaskService {
   private final  TaskRepository repo;
   private final UserRepo userRepo;

    public TaskService(TaskRepository repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo=userRepo;
    }

    public  List<Task> getAllTasks() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepo.findByUsername(username);
        return repo.findByUser(user);
    }

    public Task addTask(String title){
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        return repo.save(task);
    }

    public Task save(Task task){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username);
        task.setUser(user);
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
