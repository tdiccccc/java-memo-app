package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.application.usecase.memo.CreateMemoUseCase;
import com.example.javamemoapp.form.MemoForm;
import com.example.javamemoapp.mapper.MemoMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateController {

    private final CreateMemoUseCase createMemoUseCase;

    public CreateController(CreateMemoUseCase createMemoUseCase) {
        this.createMemoUseCase = createMemoUseCase;
    }

    /**
     * 新規作成画面
     *
     * @param model
     * @return
     */
    @GetMapping("/memos/new")
    public String newMemo(Model model) {
        model.addAttribute("memoForm", new MemoForm());
        model.addAttribute("actionUrl", "/memos");
        model.addAttribute("method", "post");
        return "memos/new";
    }

    /**
     * 新規作成メソッド
     *
     * @param memoForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/memos")
    public String create(
            @Valid @ModelAttribute("memoForm") MemoForm memoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "memos/new";
        }

        createMemoUseCase.handle(MemoMapper.toSaveRequest(memoForm));

        return "redirect:/memos";
    }
}
