package com.tutoringapp.service;

import java.util.List;

import com.tutoringapp.dto.LessonDTO;
import com.tutoringapp.entity.Lesson;
import com.tutoringapp.exception.TutoringAppException;

public interface LessonService {
	public List<Lesson> findAll() throws TutoringAppException;
	public LessonDTO getLesson(Integer lessonId) throws TutoringAppException;
}
