package com.xdw.retrofitrxmvpdemo.libding.http.manager;


public class ApiException extends RuntimeException {
    public ApiException() {
        this("服务器异常...");
    }

    public ApiException(String message) {
        super(message);
    }
}
