package com.example.studentregSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentregSystem.dao.CourseRepo;
import com.example.studentregSystem.dao.StudentRepo;
import com.example.studentregSystem.model.CourseModel;
import com.example.studentregSystem.model.StudentModel;

@Service
public class CourseService {
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	StudentRepo studentRepo;

	public CourseModel addCourse(CourseModel course) {
		
		return courseRepo.save(course);
	}

	public List<CourseModel> getAllCourse() {
		
		return courseRepo.findAll();
	}


	public void dropstudentfromCourse(int courseId, int studentId) {
		
		Optional<StudentModel>studentOpt = studentRepo.findById(studentId);

		if(studentOpt.isPresent()) {
			
			studentRepo.deleteById(studentId);
	
		}else {
			throw new RuntimeException("Course or Student not found");
		}
		
	}

}
