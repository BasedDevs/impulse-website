package com.baseddevs.ecommerce.exception.handler;

import com.baseddevs.ecommerce.exception.dto.ApiErrorResponse;
import com.baseddevs.ecommerce.exception.dto.ErrorCode;
import com.baseddevs.ecommerce.exception.exceptions.ResourceAlreadyExistsException;
import com.baseddevs.ecommerce.exception.exceptions.ResourceNotFoundException;
import com.baseddevs.ecommerce.exception.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                ZonedDateTime.now(),
                ex.getMessage(),
                ErrorCode.RESOURCE_NOT_FOUND);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    protected ResponseEntity<ApiErrorResponse> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                ZonedDateTime.now(),
                ex.getMessage(),
                ErrorCode.RESOURCE_ALREADY_EXISTS);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenExpiredException.class)
    protected ResponseEntity<ApiErrorResponse> handleTokenExpiredException(TokenExpiredException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                ZonedDateTime.now(),
                ex.getMessage(),
                ErrorCode.TOKEN_EXPIRED);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                ZonedDateTime.now(),
                "An unexpected error occurred.",
                ErrorCode.SYSTEM_ERROR);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}