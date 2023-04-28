package com.example.demo.controllers;

import com.example.demo.models.Log;
import com.example.demo.services.LogService;
import com.example.demo.util.JsonError;
import com.example.demo.util.LogErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> postJson(@RequestBody @Valid Log log,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder error = new StringBuilder();

            List<FieldError> fieldError = bindingResult.getFieldErrors();
            for (FieldError err : fieldError) {
                error.append(err.getField())
                        .append(" - ").append(err.getDefaultMessage())
                        .append(";");
            }

            throw new JsonError(error.toString());
        }

        logService.save(log);

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    private ResponseEntity<LogErrorResponse> handleException(JsonError e) {
        LogErrorResponse response = new LogErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
