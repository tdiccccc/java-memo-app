package com.example.javamemoapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MemoForm {
    @NotBlank(message = "タイトルは必須です")
    @Size(max = 100, message = "タイトルは100文字以内で入力してください")
    private String title;

    @NotBlank(message = "内容は必須です")
    @Size(max = 1000, message = "内容は1000文字以内で入力してください")
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
