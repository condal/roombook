package com.onepoint.training.bookingroom.events;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomEvent {

	public UUID roomEventid;

	public int roomId;

	public String roomType;

	public String status;

}
