/****************************************************************************************************************************
 - File Name        : Room Service Service
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is a service interface of Room Services.
  ****************************************************************************************************************************/ 




package com.cg.hotelbookingmanagementsystem.roomservice.service;

import java.util.Set;

import com.cg.hotelbookingmanagementsystem.roomservice.dto.RoomDto;
import com.cg.hotelbookingmanagementsystem.roomservice.exceptions.RoomIdNotFoundException;

public interface RoomService {

	/****************************************************************************************************************************
	 - Method Name      : addRoom
	 - Input Parameters : RoomDto roomdto
	 - Return type      : RoomDto
	 - Author           : Harshit Joshi
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting the room information into the database.
	  ****************************************************************************************************************************/ 
	public RoomDto addRoom(RoomDto room);
	
	/****************************************************************************************************************************
	 - Method Name      : deleteRoom
	 - Input Parameters : int room_id
	 - Return type      : void
	 - Author           : Harshit Joshi
	 - Creation Date    : 13-06-2020
	 - Description      : Deleting the room from the database.
	  ****************************************************************************************************************************/ 
	
	public String deleteRoom(String roomid) throws RoomIdNotFoundException;
	
	/****************************************************************************************************************************
	- Method Name      : getRoomById
	- Input Parameters : long room_id
	- Return type      : RoomDto
	- Author           : Harshit Joshi
	- Creation Date    : 13-06-2020
	- Description      : Getting the room information using the room id from the database.
	****************************************************************************************************************************/ 
	public RoomDto getRoomById(String roomid) throws RoomIdNotFoundException;
	
	/****************************************************************************************************************************
	- Method Name      : getAllRoom
	- Return type      : Set<RoomDto>
	- Author           : Harshit Joshi
	- Creation Date    : 13-06-2020
	- Description      : Getting all the rooms information from the database.
	****************************************************************************************************************************/ 
	public Set<RoomDto> getAllRoom() throws RoomIdNotFoundException;
	
	/****************************************************************************************************************************
	- Method Name      : updateRoom
	- Input Parameters : int room_id,RoomDto roomdto
	- Return type      : String
	- Author           : Harshit Joshi
	- Creation Date    : 13-06-2020
	- Description      : Updating the rooms information in the database.
	****************************************************************************************************************************/ 
	public String updateRoom(int roomid,RoomDto roomdto) throws RoomIdNotFoundException;
	
}
