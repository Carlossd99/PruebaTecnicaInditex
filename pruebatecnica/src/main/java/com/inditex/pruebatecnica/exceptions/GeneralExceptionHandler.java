package com.inditex.pruebatecnica.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type General exception handler.
 */
@Hidden
@ControllerAdvice
public class GeneralExceptionHandler {

    /**
     * Handle price not found exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Price Not Found");
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle validation exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Validation Error");
        body.put("message", ex.getBindingResult().getFieldErrors());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle general exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
