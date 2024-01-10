package com.example.studentregSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentregSystem.model.StudentModel;
import com.example.studentregSystem.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/add-students")
	public ResponseEntity<String>createStudent(@RequestBody StudentModel student){
		StudentModel studentModel = service.createStudent(student);
		return new ResponseEntity<String>("add succesfull"+" "+studentModel, HttpStatus.CREATED);
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<StudentModel>>findAllStudent(){
		List<StudentModel> students = service.getAllStudent();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@GetMapping("studentId/{studentId}")
	public ResponseEntity<StudentModel>findById(@PathVariable int studentId){
		StudentModel studentModel = service.findById(studentId);
		if(studentModel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studentModel,HttpStatus.OK);
	}
	
	@PutMapping("/studentId/{studentId}")
	public ResponseEntity<StudentModel>UpdateStudent(@PathVariable int studentId,@RequestBody StudentModel student1){
	  StudentModel student = service.updateStudent(studentId,student1);
	  if(student == null) {
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/courseid/{courseid}")
	public ResponseEntity<String>deleteCourse(@PathVariable int courseid){
	    service.deleteCourse(courseid);
	    return new ResponseEntity<String>("Delete course succesfully", HttpStatus.OK);
	}
}
