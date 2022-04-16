package com.example.systore.domain.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class Response {
    private HttpStatus status;
    private String message;

    public Response(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
