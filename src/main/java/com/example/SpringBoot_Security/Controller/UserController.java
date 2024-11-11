package com.example.SpringBoot_Security.Controller;


import com.example.SpringBoot_Security.entity.UsersEntity;
import com.example.SpringBoot_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public UsersEntity register(@RequestBody UsersEntity user) {
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody UsersEntity user) {

        return service.verify(user);
    }
}
