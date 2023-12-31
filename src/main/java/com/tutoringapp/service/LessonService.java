package com.tutoringapp.service;

import java.util.List;

import com.tutoringapp.dto.LessonDTO;
import com.tutoringapp.exception.TutoringAppException;

public interface LessonService {
	public List<LessonDTO> findAll() throws TutoringAppException;
	public LessonDTO getLesson(Integer lessonId) throws TutoringAppException;
	public Integer addLesson(LessonDTO lessonDTO) throws TutoringAppException;
	public void updateLesson(Integer lessonId, LessonDTO lessonDTO) throws TutoringAppException;
	public void deleteLesson(Integer lessonId) throws TutoringAppException;
}
