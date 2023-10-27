package com.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoringapp.dto.LessonDTO;
import com.tutoringapp.dto.StudentDTO;
import com.tutoringapp.entity.Lesson;
import com.tutoringapp.entity.Student;
import com.tutoringapp.exception.TutoringAppException;
import com.tutoringapp.repository.LessonRepository;

@Service(value = "lessonService")
@Transactional
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	@Override
	public List<LessonDTO> findAll() throws TutoringAppException {
		
		Iterable<Lesson> lessons = lessonRepository.findAll();
		List<LessonDTO> lessonDTOs = new ArrayList<>();
		
		lessons.forEach(lesson -> {
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
			
			lessonDTOs.add(lessonDTO);
		});
		
		if (lessonDTOs.isEmpty())
			throw new TutoringAppException("Service.LESSONS_NOT_FOUND");
		
		return lessonDTOs;
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

	@Override
	public Integer addLesson(LessonDTO lessonDTO) throws TutoringAppException {
		Lesson lesson = new Lesson();
		
		Student student = new Student();
		student.setStudentId(lessonDTO.getStudent().getStudentId());
		student.setName(lessonDTO.getStudent().getName());
		student.setSurname(lessonDTO.getStudent().getSurname());
		
		lesson.setStudent(student);
		lesson.setLessonDate(lessonDTO.getLessonDate());
		lesson.setStartTime(lessonDTO.getStartTime());
		lesson.setFinishTime(lessonDTO.getFinishTime());
		lesson.setDuration(lessonDTO.getDuration());
		lesson.setDescription(lessonDTO.getDescription());
		lesson.setWage(lessonDTO.getWage());
		lesson.setToPay(lessonDTO.getToPay());
		lesson.setPayment(lessonDTO.getPayment());
		
		Integer lessonId = lessonRepository.save(lesson).getLessonId();
		
		return lessonId;
	}
		
	public void updateLesson(Integer lessonId, LessonDTO lessonDTO) throws TutoringAppException {
		Optional<Lesson> optional = lessonRepository.findById(lessonId);
		
		if (optional.isEmpty())
			throw new TutoringAppException("Service.LESSON_ID_NOT_FOUND", lessonId);
		
		Lesson lesson = optional.get();
		
		Student student = new Student();
		student.setStudentId(lessonDTO.getStudent().getStudentId());
		student.setName(lessonDTO.getStudent().getName());
		student.setSurname(lessonDTO.getStudent().getSurname());
		
		lesson.setStudent(student);
		lesson.setLessonDate(lessonDTO.getLessonDate());
		lesson.setStartTime(lessonDTO.getStartTime());
		lesson.setFinishTime(lessonDTO.getFinishTime());
		lesson.setDuration(lessonDTO.getDuration());
		lesson.setDescription(lessonDTO.getDescription());
		lesson.setWage(lessonDTO.getWage());
		lesson.setToPay(lessonDTO.getToPay());
		lesson.setPayment(lessonDTO.getPayment());
	}
	
	public void deleteLesson(Integer lessonId) throws TutoringAppException {
		Optional<Lesson> optional = lessonRepository.findById(lessonId);
		
		if (optional.isEmpty())
			throw new TutoringAppException("Service.LESSON_ID_NOT_FOUND", lessonId);

		lessonRepository.delete(optional.get());
	}
	
}
