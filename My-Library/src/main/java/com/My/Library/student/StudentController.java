package com.My.Library.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController 
{
	@Autowired
	private StudentService studentService;

	@RequestMapping("")
	public String welcome()
	{
		return "Welcome to My-Library!";
	}

	@RequestMapping("/students")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}

	@RequestMapping("/students/{id}")
	public Student getStudent(@PathVariable String id)
	{
		return studentService.getStudent(id);
	}

	@RequestMapping(method=RequestMethod.POST,value="/students")
	public void addStudent(@RequestBody Student student)
	{
		studentService.addStudent(student);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/students/{id}")
	public void updateStudent(@RequestBody Student student,@PathVariable String id)
	{
		studentService.updateStudent(id,student);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/students/{id}")
	public void deleteStudent(@RequestBody Student student,@PathVariable String id)
	{
		studentService.deleteStudent(id);
	}
}



