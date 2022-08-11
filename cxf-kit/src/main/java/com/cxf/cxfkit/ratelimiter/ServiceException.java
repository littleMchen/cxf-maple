package com.cxf.cxfkit.ratelimiter;

/**
 * @description: ServiceException
 * @date: 2022/6/25 23:18
 * @author: cxf
 * @version: 1.0
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }


}
