package com.mst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mst.beans.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByTitleContaining(String title);

    @Query("SELECT c FROM Course c JOIN c.students s WHERE s.name = :studentName")
    List<Course> findCoursesByStudentName(@Param("studentName") String studentName);
}
