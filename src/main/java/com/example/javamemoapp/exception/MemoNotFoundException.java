package com.example.javamemoapp.exception;

public class MemoNotFoundException extends RuntimeException {

    public MemoNotFoundException(Long id) {
        super("メモが見つかりません。ID: " + id);
    }
}
