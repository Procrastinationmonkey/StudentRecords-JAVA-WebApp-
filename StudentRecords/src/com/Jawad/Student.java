package com.Jawad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private String age;
	private String name;
	private String grade;

	public Student() {

	}

	public Student(String age, String name, String grade) {
		super();
		this.age = age;
		this.name = name;
		this.grade = grade;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}