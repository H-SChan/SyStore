package com.example.systore.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Response {
    private int status;
    private String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
