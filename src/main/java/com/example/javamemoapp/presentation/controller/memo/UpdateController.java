package com.example.javamemoapp.presentation.controller.memo;

import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.form.MemoForm;
import com.example.javamemoapp.mapper.MemoMapper;
import com.example.javamemoapp.service.MemoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UpdateController {

    private final MemoService memoService;

    public UpdateController(MemoService memoService) {
        this.memoService = memoService;
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
            Memo memo = memoService.findById(id);

            model.addAttribute("memo", memo);
            model.addAttribute("actionUrl", "/memos/" + id);
            model.addAttribute("method", "put");

            return "memos/show";
        }

        memoService.update(id, MemoMapper.toSaveRequest(memoForm));

        return "redirect:/memos/" + id;
    }
}
