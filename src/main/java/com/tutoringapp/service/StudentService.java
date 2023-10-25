package com.tutoringapp.service;

import java.util.List;

import com.tutoringapp.dto.StudentDTO;
import com.tutoringapp.exception.TutoringAppException;

public interface StudentService {
	public List<StudentDTO> findAll() throws TutoringAppException;
	public StudentDTO getStudent(Integer studentId) throws TutoringAppException;
	public Integer addStudent(StudentDTO studentDTO) throws TutoringAppException;
	public void updateStudent(Integer studentId, StudentDTO studentDTO) throws TutoringAppException;
}
