package com.example.javamemoapp.infrastructure.persistence.memo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemoRepository
        extends JpaRepository<JpaMemoEntity, Long> {

}
