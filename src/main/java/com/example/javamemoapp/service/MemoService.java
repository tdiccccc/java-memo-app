package com.example.javamemoapp.service;

import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.dto.MemoSaveRequest;
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

    public Memo save(MemoSaveRequest request) {

        Memo memo = Memo.create(
                request.title(),
                request.content());

        return memoRepository.save(memo);
    }

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public Memo findById(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new MemoNotFoundException(id));
    }

    public Memo update(Long id, MemoSaveRequest request) {
        Memo memo = findById(id);

        memo.update(
                request.title(),
                request.content());
        return memoRepository.save(memo);
    }
}
