package zielinskin.springboote2e.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
class ScheduledTaskErrorHandler implements ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        logger.error("Scheduled task threw an exception: {}", t.getMessage(), t);
    }
}
