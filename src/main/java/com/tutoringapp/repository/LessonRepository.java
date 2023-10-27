package com.tutoringapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tutoringapp.entity.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
	
}
