package com.example.javamemoapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "memos")
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    protected Memo() {
    }

    public static Memo create(String title, String content) {

        Memo memo = new Memo();

        memo.title = title;
        memo.content = content;

        return memo;
    }

    public void update(String title, String content) {
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

    /**
     * setter
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
