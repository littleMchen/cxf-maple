package com.cxf.cxfkit.ratelimiter;

/**
 * @description: LimitType
 * @date: 2022/6/15 22:18
 * @author: cxf
 * @version: 1.0
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP
}