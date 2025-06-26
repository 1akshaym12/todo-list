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

    @PostMapping
    public String addTask(@RequestBody String title){
        taskService.addTask(title);
        return "Task added";
    }


}
