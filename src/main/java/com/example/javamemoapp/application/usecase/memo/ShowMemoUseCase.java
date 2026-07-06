package com.example.javamemoapp.application.usecase.memo;

import org.springframework.stereotype.Service;

import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.exception.MemoNotFoundException;
import com.example.javamemoapp.repository.MemoRepository;

@Service
public class ShowMemoUseCase {
    private final MemoRepository memoRepository;

    public ShowMemoUseCase(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo handle(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new MemoNotFoundException(id));
    }
}
