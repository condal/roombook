package com.onepoint.training.bookingroom.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookInformationInput {

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
