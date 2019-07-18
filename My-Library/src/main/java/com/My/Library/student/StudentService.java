package com.My.Library.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class StudentService 
{
	public List<Student> students = new ArrayList<>(Arrays.asList(
			new Student("95","Sanjay"),
			new Student("96","Suprith"),
			new Student("97","Rakesh"),
			new Student("98","Siddesh"),
			new Student("99","Shamanth")));
	
	public List<Student> getAllStudents()
	{
		return students;
	}
	
	public Student getStudent(String id)
	{
		return students.stream().filter(t-> t.getSid().equals(id)).findFirst().get();
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public void updateStudent(String id,Student student)
	{
		for(int i=0;i<students.size();i++)
		{
			Student t = students.get(i);
			if(t.getSid().equals(id))
			{
				students.set(i,student);
				return;
			}
		}
	}
	
	public void deleteStudent(String id)
	{
		students.removeIf(t->t.getSid().equals(id));
	}
}




