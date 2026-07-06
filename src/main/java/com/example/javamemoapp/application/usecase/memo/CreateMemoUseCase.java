package com.example.javamemoapp.application.usecase.memo;

import com.example.javamemoapp.dto.MemoSaveRequest;
import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.repository.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMemoUseCase {

    private final MemoRepository memoRepository;

    public CreateMemoUseCase(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo handle(MemoSaveRequest request) {
        Memo memo = Memo.create(
                request.title(),
                request.content());

        return memoRepository.save(memo);
    }
}
