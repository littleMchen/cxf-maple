package com.cxf.cxfkit.validator;

/**
 * @description: BizException
 * @date: 2022/3/19 23:44
 * @author: cxf
 * @version: 1.0
 */
public class BizException extends BaseException{

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    protected BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
