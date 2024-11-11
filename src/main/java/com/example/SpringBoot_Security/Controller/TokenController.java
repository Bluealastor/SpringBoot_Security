package com.example.SpringBoot_Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping
    public CsrfToken getCrsfTopken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
