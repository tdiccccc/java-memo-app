package com.example.javamemoapp.infrastructure.persistence.memo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "memos")
public class JpaMemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    protected JpaMemoEntity() {
    }

    public JpaMemoEntity(
            Long id,
            String title,
            String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    /**
     * getter
     */
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
