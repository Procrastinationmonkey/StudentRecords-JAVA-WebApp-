package com.Jawad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {

	StudentInfo studentInfo;

	public StudentService() {
		studentInfo = StudentInfo.instance;
	}

	public void createStudent(Student student) {
		studentInfo.getStudents().put(student.getAge(), student);
	}

	public Student getStudent(String age) {
		return studentInfo.getStudents().get(age);
	}

	public Map<String, Student> getStudents() {
		return studentInfo.getStudents();
	}

	public List<Student> getStudentAsList() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(studentInfo.getStudents().values());
		return studentList;
	}

	public int getStudentsCount() {
		return studentInfo.getStudents().size();
	}

	public void deleteStudent(String name) {
		studentInfo.getStudents().remove(name);
	}

}