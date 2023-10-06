package com.tutoringapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tutoringapp.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
