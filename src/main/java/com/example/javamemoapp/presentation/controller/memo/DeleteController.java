package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {

    private final MemoService memoService;

    public DeleteController(MemoService memoService) {
        this.memoService = memoService;
    }

    /**
     * 削除メソッド
     *
     * @param id
     * @return
     */
    @DeleteMapping("/memos/{id}")
    public String delete(@PathVariable Long id) {
        memoService.delete(id);
        return "redirect:/memos";
    }
}
