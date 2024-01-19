package com.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.Util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	ResponseEntity<ResponseStructure<String>> NotFoundException(NotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMsg("IdNotFound");
		structure.setHttpCode(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
