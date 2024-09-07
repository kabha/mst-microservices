package com.mst.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "rooms")
public class Room {
	@Id
	private String id;
	private String name;
	private Integer capacity;
}
