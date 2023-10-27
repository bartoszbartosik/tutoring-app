package com.tutoringapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoringapp.entity.Lesson;
import com.tutoringapp.exception.TutoringAppException;
import com.tutoringapp.repository.LessonRepository;

@Service(value = "lessonService")
@Transactional
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	@Override
	public List<Lesson> findAll() throws TutoringAppException {
		// TODO Auto-generated method stub
		return null;
	}
}
