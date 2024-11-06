package com.example.SpringBoot_Security.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

/*
*
* */
    @GetMapping
    public String hello(HttpServletRequest request){
        return "Hello world"+" "+ request.getSession().getId();
    }

}
