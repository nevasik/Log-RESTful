package com.example.demo.controllers;

import com.example.demo.models.Log;
import com.example.demo.services.LogService;
import com.example.demo.util.JsonError;
import com.example.demo.util.LogErrorResponse;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }


    @PostMapping
    @Operation(description = "Sending message as JSON")
    public ResponseEntity<HttpStatus> postJson(@ParameterObject @RequestBody @Valid Log log,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder error = new StringBuilder();

            List<FieldError> fieldError = bindingResult.getFieldErrors();
            for (FieldError err : fieldError) {
                error.append(err.getField())
                        .append(" - ").append(err.getDefaultMessage())
                        .append(";");
            }

            logService.writeErrorLogger(log);

            throw new JsonError(error.toString());
        }


        logService.save(log);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(description = "Getting all messages as JSON")
    public List<Log> getJson() {
        return logService.findAll();
    }

    @GetMapping("/healthcheck")
    @Operation(description = "Endpoint для healthcheck-а")
    public ResponseEntity<HttpStatus> endPoint() {
        logService.writeOkLogger();

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
