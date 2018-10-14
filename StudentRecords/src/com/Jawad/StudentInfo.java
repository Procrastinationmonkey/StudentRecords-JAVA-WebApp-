package com.Jawad;

import java.util.HashMap;
import java.util.Map;

public enum StudentInfo {
	instance;

	private Map<String, Student> students = new HashMap<String, Student>();

	private StudentInfo() {

		
		Student student = new Student("7", "Alex", "2");
		students.put("1", student);

		student = new Student("8", "Jack", "3");
		students.put("2", student);

		student = new Student("12", "Tom", "6");
		students.put("3", student);
	}

	public Map<String, Student> getStudents() {
		return students;
	}

}