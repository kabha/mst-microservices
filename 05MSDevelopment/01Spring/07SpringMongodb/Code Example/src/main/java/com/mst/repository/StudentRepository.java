package com.mst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mst.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
