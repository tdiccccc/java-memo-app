package com.example.javamemoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public String handleMemoNotFoundException(
            MemoNotFoundException exception,
            Model model) {
        model.addAttribute("message", exception.getMessage());
        return "errors/404";
    }
}
