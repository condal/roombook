package com.onepoint.training.bookingroom.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.onepoint.training.bookingroom.dtos.RoomBookInformationInput;
import com.onepoint.training.bookingroom.dtos.RoomBookMapper;
import com.onepoint.training.bookingroom.dtos.RoomBookView;
import com.onepoint.training.bookingroom.entity.RoomBook;
import com.onepoint.training.bookingroom.events.RoomEvent;
import eventstore.akka.tcp.ConnectionActor;
import eventstore.core.EventData;
import eventstore.core.WriteEvents;
import eventstore.j.EventDataBuilder;
import eventstore.j.WriteEventsBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BookCommandService implements BookingService {

	final ActorSystem system = ActorSystem.create();
	final ActorRef connection = system.actorOf(ConnectionActor.getProps());

	@Override
	public RoomBookView bookARoom(RoomBookInformationInput roomBookInformationInput) {

		RoomBook roomBook = RoomBookMapper.INSTANCE.roombookInputToENtity(roomBookInformationInput);
		RoomEvent roomEvent = new RoomEvent();
		roomEvent.setRoomType(roomBook.getRoomType());
		roomEvent.setStatus("available");
		log.info("input data : " +roomBookInformationInput.toString());
		log.info("roomEvent : " +roomEvent.toString());



		final EventData event = new EventDataBuilder("my-event_room_book").eventId(UUID.randomUUID()).data(roomEvent.toString())
				.metadata("").build();

		final WriteEvents writeEvents = new WriteEventsBuilder("my-stream").addEvent(event).expectAnyVersion().build();

		connection.tell(writeEvents, connection);


		//roomBookCommand.publishEvent();
		//RoomBookCommand roomBookCommand = new RoomBookCommand(roomEvent);
		return RoomBookMapper.INSTANCE.entityToRoomBookView(roomBook);

	}

}
