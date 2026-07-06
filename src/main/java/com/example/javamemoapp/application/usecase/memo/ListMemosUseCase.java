package com.example.javamemoapp.application.usecase.memo;

import com.example.javamemoapp.domain.memo.Memo;
import com.example.javamemoapp.domain.memo.MemoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListMemosUseCase {
    private final MemoRepository memoRepository;

    public ListMemosUseCase(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public List<Memo> handle() {
        return memoRepository.findAll();
    }
}
