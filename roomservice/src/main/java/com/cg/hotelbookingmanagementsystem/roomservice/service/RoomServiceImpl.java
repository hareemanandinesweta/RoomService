/****************************************************************************************************************************
 - File Name        : Room Service Interface Implementation
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is an implementation of service interface of Room Services.
  ****************************************************************************************************************************/ 


package com.cg.hotelbookingmanagementsystem.roomservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotelbookingmanagementsystem.roomservice.dao.RoomDao;
import com.cg.hotelbookingmanagementsystem.roomservice.dto.RoomDto;
import com.cg.hotelbookingmanagementsystem.roomservice.exceptions.RoomIdNotFoundException;


@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDao roomdao;
	
	static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);
	
	public boolean isRepositoryNotNull() {
		boolean flag = false;

		if (roomdao!= null) {
			flag = true;
			
		}
		return flag;
	}

	@Override
	public RoomDto addRoom(RoomDto room) {
		return roomdao.saveAndFlush(room);
	}

	@Override
	public String deleteRoom(String roomid) throws RoomIdNotFoundException {
		try {
			int input = Integer.parseInt(roomid);
		    roomdao.deleteById(input);
		    return "Room Deleted.";
		}catch(Exception ex) {
			throw new RoomIdNotFoundException("Room Id not Found.");
		}
		
	}

	@Override
	public Set<RoomDto> getAllRoom() throws RoomIdNotFoundException {
		 if(!isRepositoryNotNull()) {
				LOGGER.error("Problem with connectivity with service to DAO layer");
				throw new RoomIdNotFoundException("Sorry for the inconvinience, currently database is down!");	
			}
		ArrayList<RoomDto> roomList=(ArrayList)roomdao.findAll();
		HashSet<RoomDto> roomSet=new  HashSet<RoomDto>();
		for(RoomDto room : roomList)
		{
			roomSet.add(room);
		}		
		return roomSet;
	}

	@Override
	public RoomDto getRoomById(String roomid)throws RoomIdNotFoundException {
		try {
			int input = Integer.parseInt(roomid);
		Optional<RoomDto> room = roomdao.findById(input);	
		return room.get();
		}
		catch(Exception ex) {
			throw new RoomIdNotFoundException("Room Id not Found.");
		}
	}

	@Override
	public String updateRoom(int roomid, RoomDto roomdto)throws RoomIdNotFoundException {
		Optional<RoomDto> room = roomdao.findById(roomid);
		if (room.isPresent()) {
			RoomDto setRoom = room.get();
			setRoom.setHotelId(roomdto.getHotelId());
			setRoom.setRoomNo(roomdto.getRoomNo());
			setRoom.setRoomType(roomdto.getRoomType());
			setRoom.setAvgPerNightRate(roomdto.getAvgPerNightRate());
			setRoom.setAvailability(roomdto.isAvailability());
			roomdao.save(setRoom);
		}else {
			throw new RoomIdNotFoundException("Room Id not Found.");
		}
		return "Room Updated Successfully.";
	}
	
}
