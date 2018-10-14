package com.Jawad;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/students")
public class StudentsMain {

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	StudentService studentService;

	public StudentsMain() {
		studentService = new StudentService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudents() {
		return studentService.getStudentAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Student> getStudentsAsHtml() {
		return studentService.getStudentAsList();
	}

	// URI: /rest/students/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(studentService.getStudentsCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createStudent(@FormParam("age") String age,
			@FormParam("name") String name,
			@FormParam("grade") String grade,
			@Context HttpServletResponse servletResponse) throws IOException {
		Student student = new Student(age, name, grade);
		studentService.createStudent(student);
		servletResponse.sendRedirect("./students/");
	}

	@Path("{student}")
	public StudentRep getStudent(@PathParam("student") String age) {
		return new StudentRep(uriInfo, request, age);
	}

}