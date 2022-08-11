package com.cxf.cxfkit.ratelimiter;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

/**
 * @description: LuaScript
 * @date: 2022/6/25 23:15
 * @author: cxf
 * @version: 1.0
 */
@Component
public class LuaScript {


    @Bean
    public DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/RateLimiter.lua")));
        redisScript.setResultType(Long.class);
        return redisScript;
    }

}