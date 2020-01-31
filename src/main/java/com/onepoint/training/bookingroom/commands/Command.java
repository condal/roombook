package com.onepoint.training.bookingroom.commands;

import java.util.List;

import com.onepoint.training.bookingroom.events.RoomEvent;

public interface Command {

	void publishEvent();

	List<RoomEvent> loadEvent(String roomType);

}
