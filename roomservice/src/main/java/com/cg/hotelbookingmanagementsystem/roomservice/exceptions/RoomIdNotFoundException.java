/****************************************************************************************************************************
 - File Name        : Room Service Exception
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is a exception class to throw the exception for Room ID not found.
  ****************************************************************************************************************************/ 


package com.cg.hotelbookingmanagementsystem.roomservice.exceptions;

public class RoomIdNotFoundException extends Exception {

	/****************************************************************************************************************************
	 - Method Name      : RoomIdNotFoundException
	 - Input Parameters : String message
	 - Author           : Harshit Joshi
	 - Creation Date    : 13-06-2020
	 - Description      : For throwing the exception with custom message.
	  ****************************************************************************************************************************/ 
	

	public RoomIdNotFoundException(String message) {
		super(message);

	}
	
}
