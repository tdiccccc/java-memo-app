package com.example.javamemoapp.domain.memo;

public class Memo {

    private Long id;

    private String title;

    private String content;

    protected Memo() {
    }

    public static Memo create(
            String title,
            String content) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("タイトルは必須です");
        }

        Memo memo = new Memo();

        memo.title = title;
        memo.content = content;

        return memo;
    }

    public static Memo reconstruct(Long id, String title, String content) {
        Memo memo = new Memo();

        memo.id = id;
        memo.title = title;
        memo.content = content;

        return memo;
    }

    public void update(
            String title,
            String content) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("タイトルは必須です");
        }

        this.title = title;
        this.content = content;
    }

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
