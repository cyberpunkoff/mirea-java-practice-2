package ru.mirea.edu.practice15.controller;

import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/hello")
    public String hello() {
        return "hello.html";
    }
}
