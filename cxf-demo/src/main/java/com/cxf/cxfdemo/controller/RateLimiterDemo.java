package com.cxf.cxfdemo.controller;

import com.cxf.cxfkit.ratelimiter.LimitType;
import com.cxf.cxfkit.ratelimiter.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description: RateLimiterDemo
 * @date: 2022/6/25 23:59
 * @author: cxf
 * @version: 1.0
 */
@RestController
public class RateLimiterDemo {

    @GetMapping("/rateLimiterDemo")
    @RateLimiter(time = 5,count = 3,limitType = LimitType.IP)
    public String hello() {
        return "hello>>>"+new Date();
    }



}
