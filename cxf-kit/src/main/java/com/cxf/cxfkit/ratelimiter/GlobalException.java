package com.cxf.cxfkit.ratelimiter;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: GlobalException
 * @date: 2022/6/25 23:21
 * @author: cxf
 * @version: 1.0
 */
@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(ServiceException.class)
    public Map<String,Object> serviceException(ServiceException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 500);
        map.put("message", e.getMessage());
        return map;
    }
}
