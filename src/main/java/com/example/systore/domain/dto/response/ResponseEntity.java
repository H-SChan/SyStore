package com.example.systore.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseEntity<T> extends Response {
    private T data;

    public ResponseEntity(int status, String message, T data) {
        super(status, message);
        this.data = data;
    }

    public ResponseEntity(T data) {
        super();
        this.data = data;
    }
}
