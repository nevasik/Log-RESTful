package com.example.demo.services;

import com.example.demo.models.Log;
import com.example.demo.repositories.LogFileRepository;
import com.example.demo.repositories.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final Logger logger = LoggerFactory.getLogger(Log.class);

    private final LogRepository logRepository;
    private final LogFileRepository logFileRepository;
//    private final LoggingRepository loggingRepositoryDb;

    @Autowired
    public LogService(LogRepository logRepository, LogFileRepository logFileRepository) {
        this.logRepository = logRepository;
        this.logFileRepository = logFileRepository;
//        this.loggingRepositoryDb = loggingRepositoryDb;
    }

    public void save(Log log) {
        logger.info("Save to database Log={} ", log);
        logRepository.save(log);

        logger.info("Save to file Log={} ", log);
        logFileRepository.save(log);
    }

//    public void saveDbLog(JsonError jsonError) {
//        loggingRepositoryDb.save(jsonError);
//    }

    public void writeErrorLogger(Log log) {
        logger.error("Error log={} to save", log);
    }
}
