package com.mst.services;

import java.util.List;

import com.mst.beans.*;

public interface CourseServices {
	public Course saveCourse(Course course);
	List<Room> findAvailableRoomsForCourse(Long courseId);
	
}
