package com.mst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mst.model.Room;
import com.mst.model.Student;
import com.mst.services.CourseServices;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private CourseServices courseService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	  @Override
	    public void run(String... args) throws Exception {
	        // Example usage
	        String courseId = "your-course-id"; // Replace with actual course ID

	        // Fetch students for a course
	        List<Student> students = courseService.getStudentsForCourse(courseId);
	        System.out.println("Students for course: " + students);

	        // Fetch rooms for a course
	        List<Room> rooms = courseService.getRoomsForCourse(courseId);
	        System.out.println("Rooms for course: " + rooms);
	    }
}
