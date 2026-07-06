package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.application.usecase.memo.ShowMemoUseCase;
import com.example.javamemoapp.application.usecase.memo.UpdateMemoUseCase;
import com.example.javamemoapp.domain.memo.Memo;
import com.example.javamemoapp.form.MemoForm;
import com.example.javamemoapp.mapper.MemoMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UpdateController {

    private final UpdateMemoUseCase updateMemoUseCase;
    private final ShowMemoUseCase showMemoUseCase;

    public UpdateController(
            UpdateMemoUseCase updateMemoUseCase,
            ShowMemoUseCase showMemoUseCase) {
        this.updateMemoUseCase = updateMemoUseCase;
        this.showMemoUseCase = showMemoUseCase;
    }

    /**
     * 更新メソッド
     *
     * @param id
     * @param memoForm
     * @param bindingResult
     * @param model
     * @return
     */
    @PutMapping("/memos/{id}")
    public String update(
            @PathVariable Long id,
            @Valid @ModelAttribute("memoForm") MemoForm memoForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Memo memo = showMemoUseCase.handle(id);

            model.addAttribute("memo", memo);
            model.addAttribute("actionUrl", "/memos/" + id);
            model.addAttribute("method", "put");

            return "memos/show";
        }

        updateMemoUseCase.handle(id, MemoMapper.toSaveRequest(memoForm));

        return "redirect:/memos/" + id;
    }
}
