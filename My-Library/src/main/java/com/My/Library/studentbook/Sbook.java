package com.My.Library.studentbook;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.My.Library.book.Book;
import com.My.Library.student.Student;

@Entity
public class Sbook implements Serializable
{
	private static final long serialVersionUID = 1L; 
	@Id
	private String sb;
	
	public Sbook() {}
	
	public Sbook(String sb)
	{
		super();
		this.sb = sb;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "Book_Id")
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	

	@ManyToOne
	@JoinColumn(name = "Student_Id")
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getSb() {
		return sb;
	}

	public void setSb(String sb) {
		this.sb = sb;
	}
}


