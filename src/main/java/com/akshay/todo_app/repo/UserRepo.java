package com.akshay.todo_app.repo;

import com.akshay.todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);
}
