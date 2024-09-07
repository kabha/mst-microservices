package com.mst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mst.model.Room;

public interface RoomRepository extends MongoRepository<Room, String> {
}
