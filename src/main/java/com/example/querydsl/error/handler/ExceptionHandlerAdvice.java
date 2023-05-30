package com.example.querydsl.error.handler;

import com.example.querydsl.error.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<ExceptionDto> exceptionHandler(Throwable exception, Model model, HttpServletResponse httpServletResponse) {
        log.error("error!!!", exception);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionDto.builder().statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                        .message(exception.getMessage())
                        .build());
    }
}