package com.onepoint.training.bookingroom.service;

import com.onepoint.training.bookingroom.dtos.RoomBookInformationInput;
import com.onepoint.training.bookingroom.dtos.RoomBookView;

public interface BookingService {

	RoomBookView bookARoom(RoomBookInformationInput roomBookInformationInput);

}
