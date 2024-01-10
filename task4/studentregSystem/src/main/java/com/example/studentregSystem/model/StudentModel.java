package com.example.studentregSystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_student")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int studentId;

	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "student_courses",
	        joinColumns = @JoinColumn(name = "course_id")
	    )
    private List<CourseModel> registeredCourses = new ArrayList<>();

}
