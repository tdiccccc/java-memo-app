package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.application.usecase.memo.DeleteMemoUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {

    private final DeleteMemoUseCase deleteMemoUseCase;

    public DeleteController(DeleteMemoUseCase deleteMemoUseCase) {
        this.deleteMemoUseCase = deleteMemoUseCase;
    }

    /**
     * 削除メソッド
     *
     * @param id
     * @return
     */
    @DeleteMapping("/memos/{id}")
    public String delete(@PathVariable Long id) {
        deleteMemoUseCase.handle(id);
        return "redirect:/memos";
    }
}
