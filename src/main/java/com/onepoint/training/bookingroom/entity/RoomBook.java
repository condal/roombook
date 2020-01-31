package com.onepoint.training.bookingroom.entity;

import java.time.LocalDate;

import lombok.Data;


@Data
public class RoomBook {

	private int id;

	private String firstName;

	private String lastName;

	private LocalDate startDate;

	private LocalDate endDate;

	private int numberOfPersons;

	private String email;

	private String formula;

	private String roomType;

}
