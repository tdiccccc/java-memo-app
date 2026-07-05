package com.example.javamemoapp.controller;

import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.form.MemoForm;
import com.example.javamemoapp.mapper.MemoMapper;
import com.example.javamemoapp.service.MemoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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

        memoService.save(MemoMapper.toSaveRequest(memoForm));

        return "redirect:/memos";
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
        Memo memo = memoService.findById(id);

        model.addAttribute("memo", memo);
        model.addAttribute("memoForm", MemoMapper.toForm(memo));
        model.addAttribute("actionUrl", "/memos/" + id);
        model.addAttribute("method", "put");

        return "memos/show";
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
