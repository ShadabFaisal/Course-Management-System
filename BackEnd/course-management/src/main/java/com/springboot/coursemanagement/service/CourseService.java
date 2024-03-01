package com.springboot.coursemanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.coursemanagement.entity.Course;

public interface CourseService {

	public ResponseEntity<List<Course>> getAllCourses();

	public ResponseEntity<Course> getCourseById(Long id);

	public ResponseEntity<Course> addCourse(Course course);

	public ResponseEntity<Course> updateCourse(Long id, Course course);

	public ResponseEntity<String> deleteCourse(Long id);

}
