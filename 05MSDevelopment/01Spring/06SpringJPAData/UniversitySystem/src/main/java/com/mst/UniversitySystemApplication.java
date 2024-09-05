package com.mst;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mst.beans.Course;
import com.mst.beans.Room;
import com.mst.beans.Student;
import com.mst.services.CourseServices;
import com.mst.services.RoomServices;
import com.mst.services.StudentServices;


@SpringBootApplication
public class UniversitySystemApplication implements CommandLineRunner {
    @Autowired
    private StudentServices studentServices;
    
    @Autowired
    private CourseServices courseServices;

    @Autowired
    private RoomServices roomServices;
    
	public static void main(String[] args) {
		SpringApplication.run(UniversitySystemApplication.class, args);
	}

	 @Override
	    public void run(String... args) throws Exception {
		 // Create Rooms
	        Room room1 = new Room();
	        room1.setRoomNumber("A101");
	        room1.setCapacity(30);
	        roomServices.saveRoom(room1);

	        Room room2 = new Room();
	        room2.setRoomNumber("B202");
	        room2.setCapacity(50);
	        roomServices.saveRoom(room2);

	        // Create Courses
	        Course course1 = new Course();
	        course1.setTitle("Mathematics");
	        course1.setDescription("Algebra and Calculus");
	        course1.setCredit(4);
	        course1.setRoom(room1);
	        courseServices.saveCourse(course1);

	        Course course2 = new Course();
	        course2.setTitle("Physics");
	        course2.setDescription("Mechanics and Thermodynamics");
	        course2.setCredit(3);
	        course2.setRoom(room1);
	        courseServices.saveCourse(course2);

	        Course course3 = new Course();
	        course3.setTitle("Computer Science");
	        course3.setDescription("Data Structures and Algorithms");
	        course3.setCredit(5);
	        course3.setRoom(room2);
	        courseServices.saveCourse(course3);

	        // Create Students
	        Student student1 = new Student();
	        student1.setName("David Kab");
	        student1.setEmail("David.Kab@gmail.com");
	        student1.setDateOfBirth(LocalDate.of(1995, Month.JANUARY, 1));
	        student1.setSRoom(room1);
	        studentServices.findAllStudents().add(student1); 
	        studentServices.findAllStudents().add(student1);
	        studentServices.findAllStudents().add(student1);
	        studentServices.findAllStudents().add(student1);
	        
	        // Assign courses to students (assuming setter methods are available)
	        // Alternatively, manage associations properly
	        studentServices.saveStudent(student1); 

	        // Similarly, create more students and assign courses

	        // Example usage of StudentService
	        System.out.println("Finding all students:");
	        studentServices.findAllStudents().forEach(System.out::println);

	        System.out.println("Finding students by name containing 'David':");
	        studentServices.findByNameContaining("John").forEach(System.out::println);

	        System.out.println("Finding students named 'david' in room 'A101':");
	        studentServices.findByNameAndRoom("John", "A101").forEach(System.out::println);

	        System.out.println("Finding students with more than 2 courses:");
	        studentServices.findStudentsWithMoreThanNCourses(2).forEach(System.out::println);

	    }
}
