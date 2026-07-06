package com.example.javamemoapp.infrastructure.persistence.memo;

import org.springframework.stereotype.Repository;

import com.example.javamemoapp.domain.memo.Memo;
import com.example.javamemoapp.domain.memo.MemoRepository;
import com.example.javamemoapp.exception.MemoNotFoundException;
import java.util.List;

@Repository
public class MemoRepositoryImpl
        implements MemoRepository {

    private final JpaMemoRepository jpaMemoRepository;

    private final MemoPersistenceMapper mapper;

    public MemoRepositoryImpl(
            JpaMemoRepository jpaMemoRepository,
            MemoPersistenceMapper mapper) {
        this.jpaMemoRepository = jpaMemoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Memo> findAll() {
        return jpaMemoRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Memo getById(Long id) {
        return jpaMemoRepository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new MemoNotFoundException(id));
    }

    @Override
    public Memo save(Memo memo) {
        JpaMemoEntity savedEntity = jpaMemoRepository.save(mapper.toEntity(memo));
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void delete(Memo memo) {
        jpaMemoRepository.delete(mapper.toEntity(memo));
    }
}
