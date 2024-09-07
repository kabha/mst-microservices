package com.mst.model;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "courses")
public class Course {

	@Id
	private String id;
	
	@NonNull
	private String name;

	@NonNull
	private String description;

	@DBRef
	private List<Student> students; // Reference to students

	@DBRef
	private List<Room> rooms; // Reference to rooms

}
