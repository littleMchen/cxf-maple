package com.cxf.cxfkit.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @description: XmlUtils
 * @date: 2022/3/17 23:28
 * @author: cxf
 * @version: 1.0
 */
public class XmlUtils {

    public static <T> T xmlToObject(String xml , Class<T> tClass) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        T t = xmlMapper.readValue(xml, tClass);
        return t;
    }

    public static String objectToXml(Object obj) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(obj);
        return xml;
    }

}
