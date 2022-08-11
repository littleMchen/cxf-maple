package com.cxf.cxfkit.cache;

/**
 * @description: ICache
 * @date: 2022/3/23 17:32
 * @author: cxf
 * @version: 1.0
 */
public interface ICache {

      void setCache(String key, String obj, long seconds);

      String getCache(String key);

      void removeCache(String key);

}
