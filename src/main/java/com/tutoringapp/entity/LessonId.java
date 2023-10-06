package com.tutoringapp.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class LessonId implements Serializable {

	private LocalDate lessonDate;
	private LocalTime startTime;
	
	public LessonId() {}
	
	
	public LessonId(LocalDate lessonDate, LocalTime startTime) {
		this.lessonDate = lessonDate;
		this.startTime = startTime;
	}
	
	@Override
	public int hashCode() {
		return lessonDate.hashCode() + startTime.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		LessonId lessonId = (LessonId)obj;
		
		if (this.hashCode() == lessonId.hashCode()) {
			return true;
		}
		
		return false;
	}
	
}
