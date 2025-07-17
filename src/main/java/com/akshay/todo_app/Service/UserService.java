package com.akshay.todo_app.Service;

import com.akshay.todo_app.model.User;
import com.akshay.todo_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public boolean userExists(String username){
       return  repo.findByUsername(username)!=null;
    }

    public boolean emailExists(String email) {
        return repo.findByEmail(email) != null;
    }
}
