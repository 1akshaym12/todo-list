package com.akshay.todo_app.Controller;

import com.akshay.todo_app.Service.TaskService;
import com.akshay.todo_app.model.Task;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getTask(){
      return taskService.getAllTasks();
    }

    @GetMapping("/")
    public String home(){
       return "redirect:/home.html";
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @GetMapping("/toggle/{id}")
    public void toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
    }





}
