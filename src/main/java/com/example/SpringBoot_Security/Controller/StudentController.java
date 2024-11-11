package com.example.SpringBoot_Security.Controller;

import com.example.SpringBoot_Security.entity.StudentEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<StudentEntity> students = new ArrayList<>(
            List.of(
                    new StudentEntity(1, "Navin", 60),
                    new StudentEntity(2, "Kiran", 65)
            ));


    @GetMapping("/students")
    public List<StudentEntity> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");


    }


    @PostMapping("/students")
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        students.add(student);
        return student;
    }

}