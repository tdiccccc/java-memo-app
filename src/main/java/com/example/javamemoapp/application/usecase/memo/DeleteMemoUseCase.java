package com.example.javamemoapp.application.usecase.memo;

import org.springframework.stereotype.Service;

import com.example.javamemoapp.entity.Memo;
import com.example.javamemoapp.repository.MemoRepository;

@Service
public class DeleteMemoUseCase {
    private final MemoRepository memoRepository;

    public DeleteMemoUseCase(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    /**
     * 削除メソッド
     *
     * @param id
     */
    public void handle(Long id) {
        Memo memo = memoRepository.getById(id);

        memoRepository.delete(memo);
    }
}
