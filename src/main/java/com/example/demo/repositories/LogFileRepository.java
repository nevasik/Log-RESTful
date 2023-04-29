package com.example.demo.repositories;

import com.example.demo.models.Log;
import com.example.demo.util.FiledException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Repository
public class LogFileRepository {
    @Value("/home/nevasik/Desktop/projectTest/out")
    private Path path;

    public void save(Log log) {
        try {
            Files.write(path, log.toWriteFile().getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new FiledException("Failed to save file");
        }
    }
}
