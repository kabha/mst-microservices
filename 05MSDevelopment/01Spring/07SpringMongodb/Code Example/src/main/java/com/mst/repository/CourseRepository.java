package com.mst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mst.model.Course;

public interface CourseRepository extends MongoRepository<Course, String> {
}
