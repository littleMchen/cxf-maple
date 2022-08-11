package com.cxf.cxfkit.validator;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @description: ValidatorUtils
 * @date: 2022/3/17 23:28
 * @author: cxf
 * @version: 1.0
 */
public class ValidatorUtils {

    public static Validator validator;

    static {
        validator = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                //快速返回模式，有一个验证失败立即返回错误信息
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }

    /**
     * @Title: validate
     * @Description: 静态方法校验使用的
     * @Author: cxf
     * @DateTime: 2022/3/22 9:18
     * @param object
     * @return java.lang.String
     * @throws
     */
    public static String validate(Object object) {
        if(object == null){
            throw new BizException("校验对象不能为空");
        }
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        return resultValidate(validate);

    }

    /**
     * @Title: validate
     * @Description: 静态方法校验使用，并且带分组的
     * @Author: cxf
     * @DateTime: 2022/3/22 9:18
     * @param object
     * @param group
     * @return java.lang.String
     * @throws
     */
    public static String validate(Object object, Class group) {
        if (group == null) {
            return validate(object);
        } else {
            Set<ConstraintViolation<Object>> validate = validator.validate(object, group);
            return resultValidate(validate);
        }
    }
    /**
     * @Title: resultValidate
     * @Description: 将结果转换成字符串
     * @Author: cxf
     * @DateTime: 2022/3/22 9:07
     * @param validate
     * @return java.lang.String
     * @throws 
     */
    private static String resultValidate(Set<ConstraintViolation<Object>> validate) {
        if (!validate.isEmpty()) {
            final StringBuffer stringBuffer = new StringBuffer();
            validate.stream().forEach(
                    item -> stringBuffer.append(item.getMessage()).append(","));
            stringBuffer.setLength(stringBuffer.length() - 1);
            return stringBuffer.toString();
        }
        return "success";
    }
}
