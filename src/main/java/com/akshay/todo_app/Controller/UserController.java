package com.akshay.todo_app.Controller;

import com.akshay.todo_app.Service.UserService;
import com.akshay.todo_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin("*")
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        if(userService.userExists(user.getUsername())){
            redirectAttributes.addAttribute("error", "Username already exists");
            return "redirect:/registration.html";
        }
        if(userService.emailExists(user.getEmail())){
            redirectAttributes.addAttribute("error", "Email already exists");

            return "redirect:/registration.html";
        }
        userService.register(user);
        return "redirect:/login.html";
    }
}
