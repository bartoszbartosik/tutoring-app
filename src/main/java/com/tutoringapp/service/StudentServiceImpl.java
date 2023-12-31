package com.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	
	@Override
	public StudentDTO getStudent(Integer studentId) throws TutoringAppException {
		
		Optional<Student> optional = studentRepository.findById(studentId);
		
		
		if (optional.isEmpty())
			throw new TutoringAppException("Service.STUDENT_ID_NOT_FOUND", studentId);
		
		StudentDTO studentDTO = new StudentDTO();
		Student student = optional.get();
		
		studentDTO.setStudentId(student.getStudentId());
		studentDTO.setName(student.getName());
		studentDTO.setSurname(student.getSurname());
		
		return studentDTO;
	}


	@Override
	public Integer addStudent(StudentDTO studentDTO) throws TutoringAppException {

		Student student = new Student();
		student.setStudentId(studentDTO.getStudentId());
		student.setName(studentDTO.getName());
		student.setSurname(studentDTO.getSurname());
		
		Integer studentId = studentRepository.save(student).getStudentId();
		
		return studentId;
	}


	@Override
	public void updateStudent(Integer studentId, StudentDTO studentDTO) throws TutoringAppException {
		Optional<Student> optional = studentRepository.findById(studentId);
		
		if (optional.isEmpty())
			throw new TutoringAppException("Service.STUDENT_ID_NOT_FOUND", studentId);
		
		Student student = optional.get();
		student.setName(studentDTO.getName());
		student.setSurname(studentDTO.getSurname());
	}


	@Override
	public void deleteStudent(Integer studentId) throws TutoringAppException {
		Optional<Student> optional = studentRepository.findById(studentId);
		
		if (optional.isEmpty())
			throw new TutoringAppException("Service.STUDENT_ID_NOT_FOUND", studentId);
		
		studentRepository.delete(optional.get());
	}
	
	
	
}
