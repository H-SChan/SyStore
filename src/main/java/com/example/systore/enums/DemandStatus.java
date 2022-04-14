package com.example.systore.enums;

import lombok.Getter;

@Getter
public enum DemandStatus {
    DOING("진행중"),
    DONE("완료");

    private final String status;

    DemandStatus(String status) {
        this.status = status;
    }
}
