package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.application.usecase.memo.ShowMemoUseCase;
import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.mapper.MemoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowController {

    private final ShowMemoUseCase showMemoUseCase;

    public ShowController(ShowMemoUseCase showMemoUseCase) {
        this.showMemoUseCase = showMemoUseCase;
    }

    /**
     * 詳細表示
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/memos/{id}")
    public String show(@PathVariable Long id, Model model) {
        Memo memo = showMemoUseCase.handle(id);

        model.addAttribute("memo", memo);
        model.addAttribute("memoForm", MemoMapper.toForm(memo));
        model.addAttribute("actionUrl", "/memos/" + id);
        model.addAttribute("method", "put");

        return "memos/show";
    }
}
