package com.example.systore.handler;

import com.example.systore.domain.dto.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Response illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("illegalArgumentExceptionHandler()");
        log.error(e.getMessage());
        return new Response(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public Response nullPointerExceptionHandler(NullPointerException e) {
        log.error("NullPointerExceptionHandler()");
        log.error(e.getMessage());
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 오류 발생");
    }

}
