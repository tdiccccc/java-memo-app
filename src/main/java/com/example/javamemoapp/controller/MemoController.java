package com.example.javamemoapp.controller;

import com.example.javamemoapp.dto.MemoSaveRequest;
import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.form.MemoForm;
import com.example.javamemoapp.service.MemoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/memos")
    public String index(Model model) {
        model.addAttribute("memos", memoService.findAll());
        return "memos/index";
    }

    @GetMapping("/memos/new")
    public String newMemo(Model model) {
        model.addAttribute("memoForm", new MemoForm());
        model.addAttribute("actionUrl", "/memos");
        model.addAttribute("method", "post");
        return "memos/new";
    }

    @PostMapping("/memos")
    public String create(
            @Valid @ModelAttribute("memoForm") MemoForm memoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "memos/new";
        }

        MemoSaveRequest request = new MemoSaveRequest(
                memoForm.getTitle(),
                memoForm.getContent());

        memoService.save(request);

        return "redirect:/memos";
    }

    @GetMapping("/memos/{id}")
    public String show(@PathVariable Long id, Model model) {
        Memo memo = memoService.findById(id);

        MemoForm memoForm = new MemoForm();
        memoForm.setTitle(memo.getTitle());
        memoForm.setContent(memo.getContent());

        model.addAttribute("memo", memo);
        model.addAttribute("memoForm", memoForm);
        model.addAttribute("actionUrl", "/memos/" + id);
        model.addAttribute("method", "put");

        return "memos/show";
    }

    @PutMapping("/memos/{id}")
    public String update(
            @PathVariable Long id,
            @Valid @ModelAttribute("memoForm") MemoForm memoForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Memo memo = memoService.findById(id);

            model.addAttribute("memo", memo);
            model.addAttribute("actionUrl", "/memos/" + id);
            model.addAttribute("method", "put");

            return "memos/show";
        }

        MemoSaveRequest request = new MemoSaveRequest(
                memoForm.getTitle(),
                memoForm.getContent());

        memoService.save(request);

        return "redirect:/memos/" + id;
    }
}
