package com.vehicle.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class MyExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(RecordNotFoundException ex ) {
		
        return new ResponseEntity("Record Not Found", HttpStatus.NOT_FOUND);
	}

}
