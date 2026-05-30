package org.example.task4.tsk1.controller;

import lombok.Data;
import org.example.task4.tsk1.dto.CarExceptionDTO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Data
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CarExceptionDTO sizeException(MethodArgumentNotValidException ex) {
        return new CarExceptionDTO(400, ex.getFieldError().getField(), ex.getFieldError().getDefaultMessage());
    }
}
