package com.example.systore.enums;

public enum SeatStatus {
    RESERVATION("예약"),
    VACANCY("빈자리"),
    USING("사용중");

    private final String status;

    SeatStatus(String status) {
        this.status = status;
    }
}
