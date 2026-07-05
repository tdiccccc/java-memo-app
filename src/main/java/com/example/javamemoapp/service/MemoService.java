package com.example.javamemoapp.service;

import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.form.MemoForm;
import com.example.javamemoapp.repository.MemoRepository;
import com.example.javamemoapp.exception.MemoNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo save(MemoForm memoForm) {

        Memo memo = Memo.create(
                memoForm.getTitle(),
                memoForm.getContent());

        return memoRepository.save(memo);
    }

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public Memo findById(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new MemoNotFoundException(id));
    }

    public Memo update(Long id, MemoForm memoForm) {
        Memo memo = findById(id);

        memo.update(
                memoForm.getTitle(),
                memoForm.getContent());
        return memoRepository.save(memo);
    }
}
