/****************************************************************************************************************************
 - File Name        : Room Service Main
 - Author           : Harshit Joshi
 - Creation Date    : 13-06-2020
 - Description      : This is a main class for Room services
  ****************************************************************************************************************************/ 



package com.cg.hotelbookingmanagementsystem.roomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cg.hotelbookingmanagementsystem.roomservice")
@EnableEurekaClient
public class RoomserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomserviceApplication.class, args);
	}

}
