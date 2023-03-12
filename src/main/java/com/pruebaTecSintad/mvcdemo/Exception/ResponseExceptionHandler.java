package com.pruebaTecSintad.mvcdemo.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> handleAllException(Exception ex, WebRequest request) {
        String errorMessage = messageSource.getMessage("error.internal_server_error", null, LocaleContextHolder.getLocale());
        ResponseException responseException = new ResponseException(LocalDateTime.now(), errorMessage, request.getDescription(false));
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ResponseException> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        String errorMessage = messageSource.getMessage("error.model_not_found", null, LocaleContextHolder.getLocale());
        ResponseException responseException = new ResponseException(LocalDateTime.now(), errorMessage, request.getDescription(false));
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errorMessages = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            String errorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            errorMessages.add(errorMessage);
        }
        String errorMessage = messageSource.getMessage("error.bad_request", null, LocaleContextHolder.getLocale());
        ResponseException responseException = new ResponseException(LocalDateTime.now(), errorMessage, request.getDescription(false), errorMessages);
        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }
}
