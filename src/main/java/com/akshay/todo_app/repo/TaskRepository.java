package com.akshay.todo_app.repo;

import com.akshay.todo_app.model.Task;
import com.akshay.todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
