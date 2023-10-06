package com.tutoringapp.dto;

public class StudentDTO {
	private Integer studentId;
	private String name;
	private String surname;
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////   G E T T E R S   &   S E T T E R S   /////////////////////////
	// Student ID
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	// Student name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Student surname
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////   O V E R W R I T T E N   M E T H O D S   ///////////////////////

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.studentId + this.name.hashCode() + this.surname.hashCode();
	}

	// Return true if two students have the same ID
	@Override
	public boolean equals(Object obj) {
		
		StudentDTO studentDTO = (StudentDTO)obj;
		
		if (this.studentId.equals(studentDTO.getStudentId())) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.studentId + ", "
				+ this.name + ", "
				+ this.surname + "]";
	}
}
