package com.springboot.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.coursemanagement.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
