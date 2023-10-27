package com.tutoringapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutoringapp.dto.LessonDTO;
import com.tutoringapp.dto.StudentDTO;
import com.tutoringapp.exception.TutoringAppException;
import com.tutoringapp.service.LessonService;
import com.tutoringapp.service.StudentService;

@RestController
@RequestMapping(value = "/tutoringapp")
public class TutoringAPI {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private Environment environment;
	
	///////////////////////////
	////   S T U D E N T   ////
	///////////////////////////
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDTO>> getAllStudents() throws TutoringAppException {
		List<StudentDTO> studentsList = studentService.findAll();
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer studentId) throws TutoringAppException {
		StudentDTO studentDTO = studentService.getStudent(studentId);
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/students")
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) throws TutoringAppException {
		Integer studentId = studentService.addStudent(studentDTO);
		String successMessage = environment.getProperty("API.STUDENT_ADD") + studentId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer studentId, @RequestBody StudentDTO studentDTO) throws TutoringAppException {
		studentService.updateStudent(studentId, studentDTO);
		String successMessage = environment.getRequiredProperty("API.STUDENT_UPDATE") + studentId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) throws TutoringAppException {
		studentService.deleteStudent(studentId);
		String successMessage = environment.getProperty("API.STUDENT_DELETE")  + studentId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	

	///////////////////////////
	/////   L E S S O N   /////
	///////////////////////////
	@GetMapping(value = "/lessons")
	public ResponseEntity<List<LessonDTO>> getAllLessons() throws TutoringAppException {
		List<LessonDTO> lessonsList = lessonService.findAll();
		return new ResponseEntity<>(lessonsList, HttpStatus.OK);
	}

	@GetMapping(value = "lessons/{lessonId}")
	public ResponseEntity<LessonDTO> getLesson(@PathVariable Integer lessonId) throws TutoringAppException {
		LessonDTO lessonDTO = lessonService.getLesson(lessonId);
		return new ResponseEntity<>(lessonDTO, HttpStatus.OK);
	}
	
}
