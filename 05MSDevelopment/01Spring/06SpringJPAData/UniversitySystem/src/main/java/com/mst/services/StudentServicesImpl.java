package com.mst.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mst.beans.Course;
import com.mst.beans.Room;
import com.mst.beans.Student;
import com.mst.repository.CourseRepository;
import com.mst.repository.RoomRepository;
import com.mst.repository.StudentRepository;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private RoomRepository roomRepository;

	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	public List<Student> findByNameContaining(String name) {
		return studentRepository.findByNameContaining(name);
	}

	public List<Student> findByNameAndRoom(String name, String roomNumber) {
		return studentRepository.findByNameAndRoom(name, roomNumber);
	}

	public List<Student> findStudentsWithMoreThanNCourses(long l) {
		return studentRepository.findStudentsWithMoreThanNCourses(l);
	}

	@Override
	public List<Student> findStudentsWithMoreThanNCourses(int courseCount) {
		return studentRepository.findStudentsWithMoreThanNCourses(courseCount);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}

	@Override
	public void buildLearningPlan(Long studentId, List<Long> selectedCourses) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found"));

		for (Long courseId : selectedCourses) {
			Course course = courseRepository.findById(courseId)
					.orElseThrow(() -> new RuntimeException("Course not found"));

			Set<Room> availableRooms = roomRepository.findRoomsForCourse(course.getId());

			// Filter rooms where capacity allows more students
			Room selectedRoom = availableRooms.stream().filter(room -> room.getCapacity() > room.getStudents().size())
					.findFirst()
					.orElseThrow(() -> new RuntimeException("No room available for course " + course.getTitle()));

			// Assign course and room to the student
			student.getCourses().add(course);
			selectedRoom.getStudents().add(student);

			roomRepository.save(selectedRoom); // Update room
		}

		studentRepository.save(student); // Update student with chosen courses and rooms

	}

}
