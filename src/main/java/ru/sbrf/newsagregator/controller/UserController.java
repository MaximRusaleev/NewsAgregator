package ru.sbrf.newsagregator.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public class UserController {

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
}
