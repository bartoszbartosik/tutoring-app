package com.tutoringapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class LessonDTO {
	private StudentDTO studentDTO;
	private LocalDate lessonDate;
	private LocalTime startTime;
	private LocalTime finishTime;
	private LocalTime duration;
	private String description;
	private Double wage;
	private Double toPay;
	private Double payment;
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////   G E T T E R S   &   S E T T E R S   /////////////////////////
	
	// Student
	public StudentDTO getStudent() {
		return this.studentDTO;
	}
	
	public void setStudent(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}
	
	
	// Lesson date
	public LocalDate getLessonDate() {
		return lessonDate;
	}
	
	public void setLessonDate(LocalDate lessonDate) {
		this.lessonDate = lessonDate;
	}
	
	// Start time
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	// Finish time
	public LocalTime getFinishTime() {
		return finishTime;
	}
	
	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}
	
	// Duration
	public LocalTime getDuration() {
		this.duration = this.finishTime.minusNanos(this.startTime.toNanoOfDay());
		return duration;
	}
	
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	
	// Description
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Wage
	public Double getWage() {
		return wage;
	}
	
	public void setWage(Double wage) {
		this.wage = wage;
	}
	
	// To pay
	public Double getToPay() {
		
		this.getDuration();
		
		int hour = this.duration.getHour();
		int minute = this.duration.getMinute();
		
		double minuteFraction = minute / 60.0;
		
		this.toPay = (hour + minuteFraction)*this.wage;
		
		return this.toPay;
	}
	
	public void setToPay(Double toPay) {
		this.toPay = toPay;
	}
	
	// Payment
	public Double getPayment() {
		return payment;
	}
	
	public void setPayment(Double payment) {
		this.payment = payment;
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////   O V E R W R I T T E N   M E T H O D S   ///////////////////////
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.lessonDate.hashCode() + this.startTime.hashCode();
	}

	// Return true if two lessons occur at the same day and time
	@Override
	public boolean equals(Object obj) {

		LessonDTO lessonDTO = (LessonDTO)obj;
		
		if (this.lessonDate.equals(lessonDTO.getLessonDate())
				&& this.startTime.equals(lessonDTO.getStartTime())) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.studentDTO + ", "
				+ this.lessonDate + ", "
				+ this.startTime + ", "
				+ this.finishTime + ", "
				+ this.duration + ", "
				+ this.description + ", "
				+ this.wage + ", "
				+ this.toPay + ", "
				+ this.payment + "]";
	}
	
}
