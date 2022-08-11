package com.cxf.cxfkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: SimpleCache
 * @date: 2022/3/31 15:50
 * @author: cxf
 * @version: 1.0
 */
public class SimpleCache implements ICache{

    private static Map<String,String> cache = new ConcurrentHashMap<String, String>();

    @Override
    public void setCache(String key, String obj, long seconds) {
        cache.put(key,obj);
    }

    @Override
    public String getCache(String key) {
        return cache.get(key);
    }

    @Override
    public void removeCache(String key) {
        cache.remove(key);
    }



}
