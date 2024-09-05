package com.mst.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mst.beans.Room;
import com.mst.repository.RoomRepository;

@Service
public class RoomServicesImpl implements RoomServices {

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

}
