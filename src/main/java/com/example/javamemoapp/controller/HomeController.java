package com.example.javamemoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Java Memo App");
        model.addAttribute("message", "Spring Bootへようこそ！");
        model.addAttribute("author", "Daichi");
        return "index";
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam String name,
            Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/users/{id}")
    public String user(
            @PathVariable Long id,
            Model model) {
        model.addAttribute("id", id);
        return "user";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    public String submit(
            @RequestParam String name,
            Model model) {

        model.addAttribute("name", name);

        return "result";
    }
}
