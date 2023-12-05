package com.spirngbatch.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FirstStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Before Step " + stepExecution.getStepName());
        log.info("Job Exec Cont " + stepExecution.getJobExecution().getExecutionContext());
        log.info("Step Exec Cont " + stepExecution.getJobExecution().getExecutionContext());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("After Step " + stepExecution.getStepName());
        log.info("Job Exec Cont " + stepExecution.getJobExecution().getExecutionContext());
        log.info("Step Exec Cont " + stepExecution.getJobExecution().getExecutionContext());
        return null;
    }
}
