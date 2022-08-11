package com.cxf.cxfbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * @description: PersonTasklet
 * @date: 2022/8/9 23:35
 * @author: cxf
 * @version: 1.0
 */
@Component
public class PersonTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("hello world batch ");
        return RepeatStatus.FINISHED;
    }
}
