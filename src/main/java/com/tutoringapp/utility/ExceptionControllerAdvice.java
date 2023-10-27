package com.tutoringapp.utility;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tutoringapp.exception.TutoringAppException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	Environment environment;
	
	@ExceptionHandler(TutoringAppException.class)
	public ResponseEntity<ErrorInfo> tutoringAppExceptionHandler(TutoringAppException exception) {
		ErrorInfo error = new ErrorInfo();
		
		if (exception.getId() == null) {
			error.setErrorMessage(environment.getProperty(exception.getMessage()));
		} else {
			error.setErrorMessage(environment.getProperty(exception.getMessage()) + exception.getId());
		}
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
