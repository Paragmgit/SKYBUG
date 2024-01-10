package com.example.studentregSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentregSystem.model.CourseModel;

@Repository
public interface CourseRepo extends JpaRepository<CourseModel, Integer> {

}
