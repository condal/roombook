package com.onepoint.training.bookingroom.repository;

import com.onepoint.training.bookingroom.events.RoomEvent;

public interface EventRepository {

	void publishEvent(RoomEvent roomEvent);

}
