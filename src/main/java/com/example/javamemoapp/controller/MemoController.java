package com.example.javamemoapp.controller;

import com.example.javamemoapp.form.MemoForm;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemoController {

    @GetMapping("/memos/new")
    public String newMemo(Model model) {
        model.addAttribute("memoForm", new MemoForm());
        return "memos/new";
    }

    @PostMapping("/memos")
    public String create(
            @Valid @ModelAttribute("memoForm") MemoForm memoForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "memos/new";
        }
        model.addAttribute("memo", memoForm);
        return "memos/show";
    }
}
