/****************************************************************************************************************************
 - File Name        : Room Service DAO
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is a repository class used to use the database for Room Services.
  ****************************************************************************************************************************/ 


package com.cg.hotelbookingmanagementsystem.roomservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotelbookingmanagementsystem.roomservice.dto.RoomDto;

@Repository
public interface RoomDao extends JpaRepository<RoomDto,Integer>{


}
