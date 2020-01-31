package com.onepoint.training.bookingroom.dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class RoomBookView {

	private String firstName;

	private String lastName;

	private LocalDate startDate;

	private LocalDate endDate;

	private int numberOfPersons;

	private String email;

	private String formula;

	private String roomType;

	private boolean extraCleaning;

	private String phoneNumber;

}
