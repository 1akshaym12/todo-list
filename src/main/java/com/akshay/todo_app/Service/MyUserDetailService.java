package com.akshay.todo_app.Service;

import com.akshay.todo_app.model.User;
import com.akshay.todo_app.model.UserPrincipal;
import com.akshay.todo_app.repo.TaskRepository;
import com.akshay.todo_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=repo.findByUsername(username);

       if(user==null){
           throw new UsernameNotFoundException("User 404");
       }
       return new UserPrincipal(user);
    }
}
