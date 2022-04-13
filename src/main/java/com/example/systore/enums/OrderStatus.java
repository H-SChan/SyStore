package com.example.systore.enums;

public enum OrderStatus {
    DOING("진행중"),
    DONE("완료");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }
}
