package com.example.javamemoapp.mapper;

import com.example.javamemoapp.dto.MemoSaveRequest;
import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.form.MemoForm;

public class MemoMapper {

    private MemoMapper() {
    }

    public static MemoSaveRequest toSaveRequest(MemoForm form) {
        return new MemoSaveRequest(
                form.getTitle(),
                form.getContent());
    }

    public static MemoForm toForm(Memo memo) {
        MemoForm form = new MemoForm();
        form.setTitle(memo.getTitle());
        form.setContent(memo.getContent());
        return form;
    }
}
