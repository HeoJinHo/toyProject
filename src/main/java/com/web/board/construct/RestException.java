package com.web.board.construct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.Arrays;

@Getter

public class RestException extends RuntimeException {

    private ErrorType errorType;

    private String errorMsg;

    private Object[] args;


    public RestException(ErrorType errorType) {
        super();
        this.errorType = errorType;
        this.errorMsg = errorType.getMsg();
    }


    @Override
    public String getMessage() {
        String args = this.args == null ? "" : Arrays.toString(this.args);
        return this.errorType.name() + args;
    }


    public RestException() {
        super();
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(Throwable cause) {
        super(cause);
    }



}
