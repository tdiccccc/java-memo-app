package com.example.javamemoapp.repository;

import com.example.javamemoapp.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository
        extends JpaRepository<Memo, Long> {

}
