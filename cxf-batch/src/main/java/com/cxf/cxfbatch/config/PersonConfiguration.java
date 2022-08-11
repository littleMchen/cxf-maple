package com.cxf.cxfbatch.config;

import com.cxf.cxfbatch.domain.entity.Person;
import com.cxf.cxfbatch.processor.PersonProcessor;
import com.cxf.cxfbatch.tasklet.PersonTasklet;
import com.cxf.cxfbatch.writer.PersonWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @description: PersonConfiguration
 * @date: 2022/8/9 23:03
 * @author: cxf
 * @version: 1.0
 */
@Configuration
@EnableBatchProcessing
public class PersonConfiguration {

    private Logger logger = LoggerFactory.getLogger(PersonConfiguration.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private PersonTasklet personTasklet;
    @Autowired
    private MultiResourceItemReader<Person> multiResourceItemReader;
    @Autowired
    private PersonProcessor personProcessor;
    @Autowired
    private PersonWriter personWriter;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public JobRepository personJobRepository() throws Exception{
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDataSource(dataSource);
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public Job helloJob(){
        return jobBuilderFactory.get("helloJob")
                .start(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(personTasklet)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<Person, Person>chunk(65000)
                .reader(multiResourceItemReader)
                .processor(personProcessor)
                .writer(personWriter)
                .build();
    }


}
