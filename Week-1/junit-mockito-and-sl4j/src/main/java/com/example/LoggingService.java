package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logWarning() {
        logger.warn("Warning message");
    }

    public void logError() {
        logger.error("Error message");
    }

    public void logUserAction(String userName, int attempts) {
        logger.info("User {} made {} attempts", userName, attempts);
    }
}
