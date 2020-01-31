package com.onepoint.training.bookingroom.commands;

import java.util.List;

import com.onepoint.training.bookingroom.events.RoomEvent;

public class RoomBookCommand implements Command {

	private RoomEvent roomEvent;

	private List<RoomEvent> roomEvents;

	public RoomBookCommand(RoomEvent roomEvent) {
		this.roomEvent = roomEvent;
	}

	@Override
	public void publishEvent() {
		roomEvents.add(roomEvent);
	}

	@Override
	public List<RoomEvent> loadEvent(String roomType) {
		return null;
	}

}
