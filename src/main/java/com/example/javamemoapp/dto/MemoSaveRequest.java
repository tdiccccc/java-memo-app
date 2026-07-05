package com.example.javamemoapp.dto;

public class MemoSaveRequest {

    private final String title;

    private final String content;

    public MemoSaveRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String title() {
        return title;
    }

    public String content() {
        return content;
    }
}
