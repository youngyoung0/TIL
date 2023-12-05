package com.spirngbatch.demo.config;

import com.spirngbatch.demo.listener.FirstJobListener;
import com.spirngbatch.demo.listener.FirstStepListener;
import com.spirngbatch.demo.service.SecondTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class SampleJob {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SecondTasklet secondTasklet;
    private final FirstJobListener firstJobListener;
    private final FirstStepListener firstStepListener;

    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("firstJob")
                .incrementer(new RunIdIncrementer())
                .start(firstStep())
                .next(secondStep())
                .listener(firstJobListener)
                .build();
    }

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("First Step")
                .tasklet(firstTask())
                .listener(firstStepListener)
                .build();
    }

    private Tasklet firstTask(){
        return (contribution, chunkContext) -> {
            try{
                log.info("This is first tasklet step");
                return RepeatStatus.FINISHED;
            } catch (Exception e){
                throw new RuntimeException("create issue :: " + e);
            }

        };
    }

    @Bean
    public Step secondStep() {
        return stepBuilderFactory.get("second Step")
                .tasklet(secondTasklet)
                .build();
    }

}
