package com.tutoringapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoringapp.dto.LessonDTO;
import com.tutoringapp.dto.StudentDTO;
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

	@Override
	public LessonDTO getLesson(Integer lessonId) throws TutoringAppException {
		Optional<Lesson> optional = lessonRepository.findById(lessonId);
		
		if (optional.isEmpty())
			throw new TutoringAppException("Service.LESSON_ID_NOT_FOUND", lessonId);
		
		Lesson lesson = optional.get();
		
		LessonDTO lessonDTO = new LessonDTO();
		
		lessonDTO.setLessonId(lesson.getLessonId());
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(lesson.getStudent().getStudentId());
		studentDTO.setName(lesson.getStudent().getName());
		studentDTO.setSurname(lesson.getStudent().getSurname());
		
		lessonDTO.setStudent(studentDTO);
		lessonDTO.setLessonDate(lesson.getLessonDate());
		lessonDTO.setStartTime(lesson.getStartTime());
		lessonDTO.setFinishTime(lesson.getFinishTime());
		lessonDTO.setDuration(lesson.getDuration());
		lessonDTO.setDescription(lesson.getDescription());
		lessonDTO.setWage(lesson.getWage());
		lessonDTO.setToPay(lesson.getToPay());
		lessonDTO.setPayment(lesson.getPayment());
		
		return lessonDTO;
	}
	
}
