package zielinskin.springboote2e.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
class SchedulingConfiguration {
    private final ThreadPoolTaskScheduler taskScheduler;
    private final ScheduledTaskErrorHandler scheduledTaskErrorHandler;

    public SchedulingConfiguration(ThreadPoolTaskScheduler taskScheduler,
                                   ScheduledTaskErrorHandler scheduledTaskErrorHandler) {
        this.taskScheduler = taskScheduler;
        this.scheduledTaskErrorHandler = scheduledTaskErrorHandler;
    }

    @PostConstruct
    void init() {
        taskScheduler.setErrorHandler(scheduledTaskErrorHandler);
        taskScheduler.setPoolSize(1);
        taskScheduler.setThreadNamePrefix("TaskSchedulerThreads");
    }
}
