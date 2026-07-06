package com.example.javamemoapp.infrastructure.persistence.memo;

import com.example.javamemoapp.domain.memo.Memo;
import org.springframework.stereotype.Component;

@Component
public class MemoPersistenceMapper {

    public Memo toDomain(JpaMemoEntity entity) {
        return Memo.reconstruct(
                entity.getId(),
                entity.getTitle(),
                entity.getContent());
    }

    public JpaMemoEntity toEntity(Memo memo) {
        return new JpaMemoEntity(
                memo.getId(),
                memo.getTitle(),
                memo.getContent());
    }
}
