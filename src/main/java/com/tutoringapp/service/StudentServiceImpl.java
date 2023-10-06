package com.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoringapp.dto.StudentDTO;
import com.tutoringapp.entity.Student;
import com.tutoringapp.exception.TutoringAppException;
import com.tutoringapp.repository.StudentRepository;

@Service(value = "studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDTO> findAll() throws TutoringAppException {
		
		Iterable<Student> students = studentRepository.findAll();
		List<StudentDTO> studentDTOs = new ArrayList<>();
		
		students.forEach(student -> {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setStudentId(student.getStudentId());
			studentDTO.setName(student.getName());
			studentDTO.setSurname(student.getSurname());
			studentDTOs.add(studentDTO);
		});
		
		if (studentDTOs.isEmpty())
			throw new TutoringAppException("Service.STUDENTS_NOT_FOUND");
		return studentDTOs;
	}
	
	
}
