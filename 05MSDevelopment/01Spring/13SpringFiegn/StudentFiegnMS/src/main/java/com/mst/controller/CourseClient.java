package com.mst.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mst.bean.Student;

@FeignClient(name = "course-service", url = "http://localhost:8081/courses")
public interface CourseClient {

	@PostMapping("/{courseId}/enroll")
	public void enrollStudent(@PathVariable("courseId") Long courseId, @RequestBody Student student);
}
