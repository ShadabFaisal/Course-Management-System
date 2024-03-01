package com.springboot.coursemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.coursemanagement.entity.Course;
import com.springboot.coursemanagement.service.CourseService;
import com.springboot.coursemanagement.util.EmailUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@PostMapping("")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		ResponseEntity<Course> addCourse = service.addCourse(course);
		emailUtil.sendEmail("sf956822@gmail.com", "Course Enrollment Notification.", "Course Enrolled Successfully.");
		return addCourse;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Course>> getAllCourse(){
		return service.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id){
		return service.getCourseById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
		return service.updateCourse(id, course);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") Long id){
		return service.deleteCourse(id);
	}
	
	

}
