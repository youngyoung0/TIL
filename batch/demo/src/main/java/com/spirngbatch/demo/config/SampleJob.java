package com.spirngbatch.demo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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

    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("firstJob")
                .start(firstStep())
                .next(secondStep())
                .build();
    }

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("First Step")
                .tasklet(firstTask())
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
                .tasklet(firstTask())
                .build();
    }

    private Tasklet secondTask(){

        return (contribution, chunkContext) -> {
            try{
                log.info("This is second tasklet step");
                return RepeatStatus.FINISHED;
            } catch (Exception e){
                throw new RuntimeException("create issue :: " + e);
            }

        };
    }

}
