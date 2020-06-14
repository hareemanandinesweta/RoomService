/****************************************************************************************************************************
 - File Name        : Room Service DTO
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is an entity class that is used to map the data in the database.
  ****************************************************************************************************************************/ 



package com.cg.hotelbookingmanagementsystem.roomservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="room_service")
public class RoomDto {
	
	@Id
	@Column(name="room_id",length=30)
	@NotNull(message="room_id is mandatory")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="roomid_generator")
	@SequenceGenerator(name ="roomid_generator",initialValue=110,allocationSize=1,sequenceName="roomid_seq" )
	private int roomId;
	
	@Column(name="hotel_id",length=30)
	@NotNull(message="hotel_id is mandatory")
	private long hotelId;

	@Column(name="room_no",length=30)
	@NotNull(message="room_no is mandatory")
	private long roomNo;
	
	@NotNull(message="room_type is mandatory")
	@NotBlank(message="room_type is mandatory")
	@Column(name="room_type",length=30)
	@Pattern(regexp="^[a-zA-Z ]+$",message="Room type can only be in alphabets.")
	private String roomType;
	
	@Column(name="avg_per_night_rate",length=30)
	@NotNull(message="avg_per_night_rate is mandatory")
	private double avgPerNightRate;
	
	@Column(name="availability",length=30)
	@NotNull(message="availability is mandatory")
	private boolean availability;
	
	
	
	

	public RoomDto(@NotNull(message = "room_id is mandatory") int roomId,
			@NotNull(message = "hotel_id is mandatory") long hotelId,
			@NotNull(message = "room_no is mandatory") long roomNo,
			@NotNull(message = "room_type is mandatory") @NotBlank(message = "room_type is mandatory") @Pattern(regexp = "^[a-zA-Z ]+$", message = "Room type can only be in alphabets.") String roomType,
			@NotNull(message = "avg_per_night_rate is mandatory") double avgPerNightRate,
			@NotNull(message = "availability is mandatory") boolean availability) {
		super();
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.avgPerNightRate = avgPerNightRate;
		this.availability = availability;
	}

	public RoomDto() {
		super();
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public long getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(long roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getAvgPerNightRate() {
		return avgPerNightRate;
	}

	public void setAvgPerNightRate(double avgPerNightRate) {
		this.avgPerNightRate = avgPerNightRate;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", hotelId=" + hotelId + ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", avgPerNightRate=" + avgPerNightRate + ", availability=" + availability + "]";
	}
	
	
	
}
