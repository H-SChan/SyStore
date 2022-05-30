package com.example.systore.domain.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class Response {
    private int status;
    private String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response() {
        this.status = HttpStatus.OK.value();
        this.message = "성공";
    }
}
