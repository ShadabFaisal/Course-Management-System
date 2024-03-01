package com.springboot.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.coursemanagement.entity.Course;
import com.springboot.coursemanagement.exception.CourseNotFoundException;
import com.springboot.coursemanagement.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository repository;
	
	@Override
	public ResponseEntity<Course> addCourse(Course course) {
		Course savedCourse=repository.save(course);
		return new ResponseEntity<>(savedCourse,HttpStatus.CREATED);
	}

	
	@Override
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses=repository.findAll();
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course> getCourseById(Long id) {
		Course course=repository.findById(id).orElseThrow(CourseNotFoundException::new);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Course> updateCourse(Long id, Course course) {
		Course old=repository.findById(id).orElseThrow(CourseNotFoundException::new);
		old.setTitle(course.getTitle());
		old.setDescription(course.getDescription());
		
		Course c=repository.save(old);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteCourse(Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Course Deleted!",HttpStatus.OK);
	}

}
