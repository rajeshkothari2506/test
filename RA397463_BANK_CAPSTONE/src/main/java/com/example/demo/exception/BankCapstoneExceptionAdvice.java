package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BankCapstoneExceptionAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)	
	@ResponseBody ExceptionResponse handleCustomerNotFound(CustomerNotFoundException exc,HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(exc.getMessage());
		response.setUri(request.getRequestURI());
		return response;
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)	
	@ResponseBody ExceptionResponse handleAccountNotFound(AccountNotFoundException exc,HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(exc.getMessage());
		response.setUri(request.getRequestURI());
		return response;
	}
}
