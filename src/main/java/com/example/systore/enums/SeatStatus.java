package com.example.systore.enums;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public enum SeatStatus {
    RESERVATION("예약"),
    VACANCY("빈자리"),
    USING("사용중");

    private final String status;

    SeatStatus(String status) {
        this.status = status;
    }
}
