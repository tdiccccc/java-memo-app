package com.example.javamemoapp.application.usecase.memo;

import org.springframework.stereotype.Service;

import com.example.javamemoapp.dto.MemoSaveRequest;
import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.repository.MemoRepository;

@Service
public class UpdateMemoUseCase {

    private final MemoRepository memoRepository;

    public UpdateMemoUseCase(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public void handle(Long id, MemoSaveRequest request) {

        Memo memo = memoRepository.getById(id);

        memo.update(
                request.title(),
                request.content());

        memoRepository.save(memo);
    }
}
