package com.cxf.cxfkit.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: JsonUtils
 * @date: 2022/3/17 23:28
 * @author: cxf
 * @version: 1.0
 */
public class JsonUtils {


    public static <T> T jsonToObject(String json , Class<T> tClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

/*        Reflections reflections = new Reflections("com.cxf.cxftools.demo");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(JsonTypeName.class);
        classSet.parallelStream().forEach(clazz -> objectMapper.registerSubtypes(clazz));*/

        T t = objectMapper.readValue(json, tClass);
        return t;
    }

    public static String objectToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(obj);
        return json;
    }
}
