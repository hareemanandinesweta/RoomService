/****************************************************************************************************************************
 - File Name        : Room Service Controller
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is an end point controller to consume Room Services.
  ****************************************************************************************************************************/ 



package com.cg.hotelbookingmanagementsystem.roomservice.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hotelbookingmanagementsystem.roomservice.dto.RoomDto;
import com.cg.hotelbookingmanagementsystem.roomservice.exceptions.RoomIdNotFoundException;
import com.cg.hotelbookingmanagementsystem.roomservice.service.RoomService;

@RestController
@RequestMapping("/roomservice")
@Validated
public class RoomController {

	@Autowired
	private RoomService roomservice;

	
	//localhost:9876/roomservice/addRoom
	// ADDING ROOM
	/****************************************************************************************************************************
	 - Method Name      : addRoom
	 - Input Parameters : RoomDto roomdto
	 - Return type      : ResponseEntity<RoomDto>
	 - Author           : Harshit Joshi
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting the room information into the database.
	 - End Point Url    : localhost:9876
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/addRoom")
	public ResponseEntity<RoomDto> addRoom(@Valid @RequestBody RoomDto roomdto) {
		try {
			roomservice.addRoom(roomdto);
			return new ResponseEntity<RoomDto>(roomdto, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	// localhost:9876/roomservice/deleteroom/
	// DELETING ROOM
	/****************************************************************************************************************************
	 - Method Name      : deleteRoom
	 - Input Parameters : int roomid
	 - Return type      : ResponseEntity<String>
	 - Author           : Harshit Joshi
	 - Creation Date    : 13-06-2020
	 - Description      : Deleting the room from the database.
	 - End Point Url    : localhost:9876
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("/deleteroom/{roomid}")
	public ResponseEntity<String> deleteRoom(@Valid @PathVariable String roomid) throws RoomIdNotFoundException {
			String msg = roomservice.deleteRoom(roomid);
			return new ResponseEntity<>(msg, HttpStatus.NO_CONTENT);
		
	}
	
	// localhost:9876/roomservice/getroombyid/
	// GET ROOM INFORMATION BY ROOM ID
	/****************************************************************************************************************************
	- Method Name      : getRoomById
	- Input Parameters : int roomid
	- Return type      : ResponseEntity
	- Author           : Harshit Joshi
	- Creation Date    : 13-06-2020
	- Description      : Getting the room information using the room id from the database.
	- End Point Url    : localhost:9876
	****************************************************************************************************************************/ 

	@GetMapping("/getroombyid/{roomid}")
	public ResponseEntity getRoomById(@Valid @PathVariable("roomid") String roomId) throws RoomIdNotFoundException {
		RoomDto roomdto = roomservice.getRoomById(roomId);
		return new ResponseEntity(roomdto, HttpStatus.OK);
	}
	
	
	// localhost:9876/roomservice/getallroom
	// GET ALL ROOM INFORMATION
	/****************************************************************************************************************************
	- Method Name      : getAllRoom
	- Return type      : HashSet<RoomDto>
	- Author           : Harshit Joshi
	- Creation Date    : 13-06-2020
	- Description      : Getting all the rooms information from the database.
	- End Point Url    : localhost:9876
	 * @throws RoomIdNotFoundException 
	****************************************************************************************************************************/ 

	@GetMapping("/getallroom")
	public HashSet<RoomDto> getAllRoom() throws RoomIdNotFoundException {
		return (HashSet) roomservice.getAllRoom();
	}

	
	// localhost:9876/roomservice/updateroom/
	// UPDATING THE ROOM INFORMATION
	/****************************************************************************************************************************
	- Method Name      : updateRoom
	- Input Parameters : int roomid,RoomDto roomdto
	- Return type      : ResponseEntity<String>
	- Author           : Harshit Joshi
	- Creation Date    : 13-06-2020
	- Description      : Updating the rooms information in the database.
	- End Point Url    : localhost:9876
	****************************************************************************************************************************/ 
	@PutMapping("/updateroom/{roomid}")
	public ResponseEntity<String> updateRoom(@Valid @PathVariable("roomid") int roomid,@Valid @RequestBody RoomDto roomdto)throws RoomIdNotFoundException {
		try {
			String msg = roomservice.updateRoom(roomid, roomdto);
			return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
