package com.spirngbatch.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecondTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        try{
            log.info("This is second tasklet step");
            return RepeatStatus.FINISHED;
        } catch (Exception e){
            throw new RuntimeException("create issue :: " + e);
        }

    }
}
