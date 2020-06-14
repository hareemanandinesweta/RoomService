/****************************************************************************************************************************
 - File Name        : Room Service Exception Controller
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is a exception controller class to handle the exceptions.
  ****************************************************************************************************************************/ 

package com.cg.hotelbookingmanagementsystem.roomservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomServiceExceptionController {
	
	/****************************************************************************************************************************
	 - Method Name      : RoomNotFoundException
	 - Input Parameters : RoomIdNotFoundException exception
	 - Author           : Harshit Joshi
	 - Creation Date    : 13-06-2020
	 - Description      : For handling the exception with custom message.
	  ****************************************************************************************************************************/ 
	

	@ExceptionHandler(RoomIdNotFoundException.class)
   public String roomNotFoundException(RoomIdNotFoundException exception) {
		
		return exception.getMessage();
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolation(Exception ex) {
		return new ResponseEntity<>(": " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
