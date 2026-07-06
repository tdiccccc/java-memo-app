package com.example.javamemoapp.domain.memo;

import java.util.List;

public interface MemoRepository {

    List<Memo> findAll();

    Memo getById(Long id);

    Memo save(Memo memo);

    void delete(Memo memo);
}
