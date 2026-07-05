package com.example.javamemoapp.service;

import com.example.javamemoapp.form.MemoForm;
import org.springframework.stereotype.Service;

@Service
public class MemoService {
    public MemoForm save(MemoForm memoForm) {

        System.out.println("メモ保存");

        return memoForm;
    }
}
