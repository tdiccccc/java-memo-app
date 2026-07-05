package com.example.javamemoapp.controller;

import com.example.javamemoapp.form.MemoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String create(@ModelAttribute MemoForm memoForm, Model model) {
        model.addAttribute("memo", memoForm);
        return "memos/show";
    }
}
