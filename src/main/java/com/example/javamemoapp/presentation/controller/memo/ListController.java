package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.service.MemoService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    private final MemoService memoService;

    public ListController(MemoService memoService) {
        this.memoService = memoService;
    }

    /**
     * 一覧表示
     *
     * @param model
     * @return
     */
    @GetMapping("/memos")
    public String index(Model model) {
        model.addAttribute("memos", memoService.findAll());
        return "memos/index";
    }
}
