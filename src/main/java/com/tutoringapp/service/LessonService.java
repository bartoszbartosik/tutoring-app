package com.tutoringapp.service;

import java.util.List;

import com.tutoringapp.dto.LessonDTO;
import com.tutoringapp.exception.TutoringAppException;

public interface LessonService {
	public List<LessonDTO> findAll() throws TutoringAppException;
}
