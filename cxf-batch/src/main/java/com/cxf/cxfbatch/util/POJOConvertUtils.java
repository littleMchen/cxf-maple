package com.cxf.cxfbatch.util;

import com.cxf.cxfbatch.annotation.ConvertOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * description: POJOConvertUtils <br>
 * date: 2021/11/13 1:00 <br>
 * author: cxf <br>
 * version: 1.0 <br>
 */
public class POJOConvertUtils {

    private static final Logger logger = LoggerFactory.getLogger(POJOConvertUtils.class);

    /**
     * @Title: pojoToStrings
     * @Description: pojo转换成顺序字符串
     * @Author: cxf
     * @DateTime: 2021/11/13 2:13
     * @param clazz
     * @return java.lang.String[]
     * @throws
     */
    public static  String[] pojoToStrings(Class clazz){

        Field[] fields = clazz.getDeclaredFields();
        String[] strs = new String[fields.length];
        int count = 0;
        for (int i = 0; i < fields.length; i++) {
            Field field =  fields[i];
            ConvertOrder annotation = field.getAnnotation(ConvertOrder.class);
            if(annotation!=null){
                String order = annotation.order();
                strs[Integer.valueOf(order)] = field.getName().toLowerCase();
                count++;
            }
        }
        if(count!=fields.length){
            String[] temp = new String[count];
            int tmpcount = 0;
            for (int i = 0; i < strs.length; i++) {
                String str =  strs[i];
                if(str!=null){
                    temp[tmpcount] = str;
                    tmpcount++;
                }
            }
            strs = temp;
        }

        logger.info("{} 的对象转换后是：>>>> {}",new Object[]{clazz,strs});
        return strs;
    }

    /**
     * @Title: pojotoSql
     * @Description: pojo转换成SQL 未考虑而驼峰 即 userName --> user_name
     * @Author: cxf
     * @DateTime: 2021/11/13 2:24
     * @param clazz
     * @return java.lang.String
     * @throws
     */
    public static String pojotoSql(Class clazz){
        String[] strings = POJOConvertUtils.pojoToStrings(clazz);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ")
                .append(clazz.getSimpleName().toLowerCase())
                .append(" values(");
        int strcount = strings.length;
        for (int i = 0; i < strcount; i++) {
            if(i == (strcount-1)){
                stringBuilder.append(":"+strings[i]+")");
            }else {
                stringBuilder.append(":"+strings[i]+",");
            }
        }
        logger.info("{} 的对象转换后sql是：>>>> {}",new Object[]{clazz,stringBuilder.toString()});
        return stringBuilder.toString();
    }

}
