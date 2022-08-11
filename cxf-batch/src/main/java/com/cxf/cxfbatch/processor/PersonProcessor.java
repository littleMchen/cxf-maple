package com.cxf.cxfbatch.processor;

import com.cxf.cxfbatch.domain.entity.Person;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @description: PersonProcessor
 * @date: 2022/8/10 0:00
 * @author: cxf
 * @version: 1.0
 */
@Component
@StepScope
public class PersonProcessor implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person item) throws Exception {
        System.out.println(item.toString());
        return item;
    }
}
