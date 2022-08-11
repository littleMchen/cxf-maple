package com.cxf.cxfbatch.domain.entity;

import com.cxf.cxfbatch.annotation.ConvertOrder;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * description: Person <br>
 * date: 2021/11/11 23:26 <br>
 * author: cxf <br>
 * version: 1.0 <br>
 */
@Repository
public class Person implements Serializable {
    private final long serialVersionUID = 1L;

    @ConvertOrder(order = "1")
    private String id;
    //@Size(min = 2, max = 20)
    @ConvertOrder(order = "2")
    private String name;
    @ConvertOrder(order = "3")
    private int age;
    @ConvertOrder(order = "4")
    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
