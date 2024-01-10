package com.example.studentregSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentregSystem.dao.CourseRepo;
import com.example.studentregSystem.dao.StudentRepo;
import com.example.studentregSystem.model.StudentModel;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	CourseRepo courseRepo;

	public StudentModel createStudent(StudentModel student) {

		return studentRepo.save(student);
	}

	public List<StudentModel> getAllStudent() {

		return studentRepo.findAll();
	}

	public StudentModel findById(int studentId) {

		return studentRepo.findById(studentId).get();
	}

	public StudentModel updateStudent(int studentId, StudentModel student1) {
		StudentModel student = studentRepo.findById(studentId).get();

		student.setName(student1.getName());
		student.setRegisteredCourses(student1.getRegisteredCourses());
		return studentRepo.save(student);
	}

	public void deleteCourse(int courseid) {
		courseRepo.deleteById(courseid);
	}

}
