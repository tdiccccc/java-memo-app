package com.example.javamemoapp.form;

public class MemoForm {
    private String title;
    private String content;

    public String getTitle() {
        System.out.println("setTitle called : " + title);
        return title;
    }

    public void setTitle(String title) {
        System.out.println("getTitle called");
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
