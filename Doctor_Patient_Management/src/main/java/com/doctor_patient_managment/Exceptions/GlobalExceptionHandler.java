package com.doctor_patient_managment.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EnumException.class)
	public ResponseEntity<ErrorDetails> EnumExceptionHandler(EnumException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	

}
