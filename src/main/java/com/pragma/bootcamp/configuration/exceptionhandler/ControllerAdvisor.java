package com.pragma.bootcamp.configuration.exceptionhandler;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.SupplierAlreadyExistsException;
import  com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import  com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.TechCapAlreadyExistsException;
import  com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.BootcampAlreadyExistsException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.SupplierNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.TechCapNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.BootcampNotFoundException;
import com.pragma.bootcamp.configuration.Constants;
import com.pragma.bootcamp.domain.exception.EmptyFieldException;
import com.pragma.bootcamp.domain.exception.MaxDescCharactersException;
import com.pragma.bootcamp.domain.exception.MaxNameCharactersException;
import com.pragma.bootcamp.domain.exception.NegativeNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.EMPTY_FIELD_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(NegativeNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeNotAllowedException(NegativeNotAllowedException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(SupplierAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleSupplierAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNoDataFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleProductAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.PRODUCT_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(TechnologyAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleTechnologyAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(TechCapAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleTechCapAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.TECH_CAP_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(BootcampAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleBootcampAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.BOOTCAMP_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleSupplierNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.SUPPLIER_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(TechnologyNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTechnologyNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.TECHNOLOGY_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(TechCapNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTechCapNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.TECH_CAP_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(BootcampNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBootcampNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.BOOTCAMP_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(MaxDescCharactersException.class)
    public ResponseEntity<ExceptionResponse> handleMaxDescCharactersException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.FIELD_DESCRIPTION_MAX_CHARACTERS_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(MaxNameCharactersException.class)
    public ResponseEntity<ExceptionResponse> handleMaxNameCharactersException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.FIELD_NAME_MAX_CHARACTERS_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
}
