package com.example.javamemoapp.application.usecase.memo;

import com.example.javamemoapp.dto.MemoSaveRequest;
import com.example.javamemoapp.domain.memo.Memo;
import com.example.javamemoapp.domain.memo.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMemoUseCase {

    private final MemoRepository memoRepository;

    public CreateMemoUseCase(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public void handle(MemoSaveRequest request) {
        Memo memo = Memo.create(
                request.title(),
                request.content());

        memoRepository.save(memo);
    }
}
