package com.cxf.cxfbatch.writer;

import com.cxf.cxfbatch.domain.entity.Person;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: PersonWriter
 * @date: 2022/8/10 0:02
 * @author: cxf
 * @version: 1.0
 */
@Component
@StepScope
public class PersonWriter implements ItemWriter<Person> {

    @Override
    public void write(List<? extends Person> items) throws Exception {
        System.out.println(" writer >>>>>>>>>>>>>>>>>>>"+ items);
    }
}
