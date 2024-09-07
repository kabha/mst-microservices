package com.mst.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mst.model.Course;
import com.mst.model.Room;
import com.mst.model.Student;
import com.mst.repository.CourseRepository;


@Service
public class CourseServices {
	@Autowired
    private CourseRepository courseRepository;

    public List<Student> getStudentsForCourse(String courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.map(Course::getStudents).orElse(null);
    }

    public List<Room> getRoomsForCourse(String courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.map(Course::getRooms).orElse(null);
    }
}
