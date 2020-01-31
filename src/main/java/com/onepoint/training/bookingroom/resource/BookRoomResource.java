package com.onepoint.training.bookingroom.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onepoint.training.bookingroom.dtos.RoomBookInformationInput;
import com.onepoint.training.bookingroom.dtos.RoomBookView;
import com.onepoint.training.bookingroom.service.BookingService;

@RestController
@RequestMapping(("/room/booking"))
public class BookRoomResource {

	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<RoomBookView> bookroom(RoomBookInformationInput roomBookInformationInput) {
		RoomBookView roomBookView = bookingService.bookARoom(roomBookInformationInput);
		return new ResponseEntity(roomBookView, HttpStatus.OK);
	}

}
