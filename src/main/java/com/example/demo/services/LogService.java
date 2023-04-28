package com.example.demo.services;

import com.example.demo.models.Log;
import com.example.demo.repositories.LogFileRepository;
import com.example.demo.repositories.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final Logger logger = LoggerFactory.getLogger(Log.class);

    private final LogRepository logRepository;
    private final LogFileRepository logFileRepository;

    @Autowired
    public LogService(LogRepository logRepository, LogFileRepository logFileRepository) {
        this.logRepository = logRepository;
        this.logFileRepository = logFileRepository;
    }

    public void save(Log log) {
        logger.info("Save Log={} to database", log);
        logRepository.save(log); //

        logger.info("Save log={} to file", log);
        logFileRepository.save(log);
    }
}
