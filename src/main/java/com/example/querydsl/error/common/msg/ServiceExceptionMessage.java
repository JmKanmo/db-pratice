package com.example.querydsl.error.common.msg;

public enum ServiceExceptionMessage {
    QUERY_FAIL("쿼리 실행에 실패하였습니다.");

    private final String message;

    ServiceExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
