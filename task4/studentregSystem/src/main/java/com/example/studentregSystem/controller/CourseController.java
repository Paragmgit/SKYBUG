package com.example.studentregSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentregSystem.model.CourseModel;
import com.example.studentregSystem.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping("/add-course")
	public ResponseEntity<String> addCourse(@RequestBody CourseModel course) {
		CourseModel courseModel = courseService.addCourse(course);
        return new ResponseEntity<String>("Add succesfully"+" "+courseModel,HttpStatus.CREATED); 
	}

	@GetMapping("/find-all-courses")
	public List<CourseModel> getAllCourses() {
		List<CourseModel> courseModels = courseService.getAllCourse();
		return courseModels;
	}

	@DeleteMapping("{courseId}/students/{studentId}")
	public ResponseEntity<String> dropstudentfromCourse(@PathVariable int courseId, @PathVariable int studentId) {
		courseService.dropstudentfromCourse(courseId, studentId);
		return new ResponseEntity<String>("Drop course succefully", HttpStatus.OK);
	}
}
