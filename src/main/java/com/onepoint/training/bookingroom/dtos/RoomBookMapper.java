package com.onepoint.training.bookingroom.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.onepoint.training.bookingroom.entity.RoomBook;

@Mapper
public interface RoomBookMapper {

	RoomBookMapper INSTANCE = Mappers.getMapper(RoomBookMapper.class);

	// @Mappings({ @Mapping(target = "firstName", source = "firstName"),
	// @Mapping(target = "lastName", source = "lastName"), @Mapping(target =
	// "startDate", source = "startDate") })
	RoomBook roombookInputToENtity(RoomBookInformationInput input);

	// @Mappings({ @Mapping(target = "firstName", source = "firstName"),
	// @Mapping(target = "lastName", source = "lastName"), @Mapping(target =
	// "startDate", source = "startDate") })
	RoomBookView entityToRoomBookView(RoomBook roomBook);

}
