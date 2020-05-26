package com.joaodartora.dataanalyzer;

import com.joaodartora.dataanalyzer.config.SchedulerConfig;
import com.joaodartora.dataanalyzer.file.Processor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class App extends SchedulerConfig {

    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduler.scheduleAtFixedRate(Processor::verifyNewFilesAndStartProccessing, FIRST_EXECUTION_DELAY, DELAY_BETWEEN_EXECUTIONS, DELAY_TIMEUNIT);
    }

}
