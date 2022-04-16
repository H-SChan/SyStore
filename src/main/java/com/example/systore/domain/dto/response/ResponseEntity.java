package com.example.systore.domain.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ResponseEntity<T> extends Response {
    private T data;

    public ResponseEntity(HttpStatus status, String message, T data) {
        super(status, message);
        this.data = data;
    }
}
