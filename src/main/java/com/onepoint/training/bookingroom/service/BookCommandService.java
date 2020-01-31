package com.onepoint.training.bookingroom.service;

import org.springframework.stereotype.Service;

import com.onepoint.training.bookingroom.commands.RoomBookCommand;
import com.onepoint.training.bookingroom.dtos.RoomBookInformationInput;
import com.onepoint.training.bookingroom.dtos.RoomBookMapper;
import com.onepoint.training.bookingroom.dtos.RoomBookView;
import com.onepoint.training.bookingroom.entity.RoomBook;
import com.onepoint.training.bookingroom.events.RoomEvent;

import java.util.Random;
import java.util.UUID;

@Service
public class BookCommandService implements BookingService {

	@Override
	public RoomBookView bookARoom(RoomBookInformationInput roomBookInformationInput) {
		RoomBook roomBook = RoomBookMapper.INSTANCE.roombookInputToENtity(roomBookInformationInput);
		RoomEvent roomEvent = new RoomEvent();
		roomEvent.setRoomType(roomBook.getRoomType());
		RoomBookCommand roomBookCommand = new RoomBookCommand(roomEvent);
		roomBookCommand.publishEvent();
		return RoomBookMapper.INSTANCE.entityToRoomBookView(roomBook);

	}

}
