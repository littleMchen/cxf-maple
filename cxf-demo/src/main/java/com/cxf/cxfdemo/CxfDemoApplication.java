package com.cxf.cxfdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cxf.cxfdemo","com.cxf.cxfkit"})
//@ComponentScan(basePackages = {"com.cxf.cxfkit","com.cxf.cxfdemo"})
public class CxfDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxfDemoApplication.class, args);
    }

}
