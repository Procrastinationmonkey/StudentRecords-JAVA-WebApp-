package com.Jawad;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class StudentRep {

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String age;

	StudentService studentService;

	public StudentRep(UriInfo uriInfo, Request request, String age) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.age= age;
		studentService = new StudentService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student getStudent() {
		Student student = studentService.getStudent(age);
		return student;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Student getStudentAsHtml() {
		Student student = studentService.getStudent(age);
		return student;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putStudent(JAXBElement<Student> studentElement) {
		Student student = studentElement.getValue();
		Response response;
		if (studentService.getStudents().containsKey(student.getAge())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		studentService.createStudent(student);
		return response;
	}

	@DELETE
	public void deleteStudent() {
		studentService.deleteStudent(age);
	}

}