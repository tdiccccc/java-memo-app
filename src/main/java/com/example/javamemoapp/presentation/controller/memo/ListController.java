package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.application.usecase.memo.ListMemosUseCase;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    private final ListMemosUseCase listMemosUseCase;

    public ListController(ListMemosUseCase listMemosUseCase) {
        this.listMemosUseCase = listMemosUseCase;
    }

    /**
     * 一覧表示
     *
     * @param model
     * @return
     */
    @GetMapping("/memos")
    public String index(Model model) {
        model.addAttribute("memos", listMemosUseCase.handle());
        return "memos/index";
    }
}
