package com.cxf.cxfkit.ratelimiter;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: IpUtils
 * @date: 2022/6/25 23:20
 * @author: cxf
 * @version: 1.0
 */
public class IpUtils {

    public static char[] getIpAddr(HttpServletRequest request) {
        return  request.getRemoteAddr().toCharArray();
    }
}

