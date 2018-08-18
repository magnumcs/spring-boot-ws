package com.portf.magnum.springbootws.service.exception;

public class DataIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
