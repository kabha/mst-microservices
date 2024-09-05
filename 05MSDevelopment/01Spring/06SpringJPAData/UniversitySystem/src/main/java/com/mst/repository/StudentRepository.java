package com.mst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mst.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByNameContaining(String name);

    List<Student> findByCourses_Title(String title);

   
    @Query("SELECT s FROM Student s WHERE s.name = :name AND s.sRoom.roomName = :roomName")
    List<Student> findByNameAndRoom(@Param("name") String name, @Param("roomName") String roomName);


    
    @Query("SELECT s FROM Student s JOIN s.courses c GROUP BY s.id HAVING COUNT(c) > :courseCount")
    List<Student> findStudentsWithMoreThanNCourses(@Param("courseCount") long courseCount);
}
