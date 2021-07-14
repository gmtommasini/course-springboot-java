package com.gmtommasini.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gmtommasini.course.services.exceptions.DatabaseException;
import com.gmtommasini.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice //intercepts exceptions to handle
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // this method intercepts exception of ResourceNotFoundException type and handles it
	public ResponseEntity<StandardError> resourceNotFound( ResourceNotFoundException e, HttpServletRequest request){
		String error ="Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);		
	}
	
	
	@ExceptionHandler(DatabaseException.class) // this method intercepts exception of ResourceNotFoundException type and handles it
	public ResponseEntity<StandardError> databaseError( DatabaseException e, HttpServletRequest request){
		String error ="DataBase error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);		
	}
}
