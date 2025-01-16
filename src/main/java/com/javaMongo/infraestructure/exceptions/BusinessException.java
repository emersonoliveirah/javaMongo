package com.javaMongo.infraestructure.exceptions;

public class BusinessException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public BusinessException(Throwable cause) {
        super(cause);
    }
}
