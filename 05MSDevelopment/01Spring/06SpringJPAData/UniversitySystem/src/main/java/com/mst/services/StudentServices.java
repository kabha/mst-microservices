package com.mst.services;

import java.util.List;
import com.mst.beans.Student;

//@Service
public interface StudentServices {

	public List<Student> findAllStudents();
	public List<Student> findByNameContaining(String name);
	public List<Student> findByNameAndRoom(String name, String roomNumber);
    public List<Student> findStudentsWithMoreThanNCourses(int l);
	public Student saveStudent(Student student);
	void buildLearningPlan(Long studentId, List<Long> selectedCourses);
}
