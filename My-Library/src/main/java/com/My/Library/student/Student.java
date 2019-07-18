package com.My.Library.student;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STUDENT")
public class Student 
{
	private String sid;
	private String sname;

	public Student(){} 
	
	public Student(String sid) 
	{
		super();
		this.sid = sid;
	}
	
	public Student(String sid,String sname) 
	{
		super();
		this.sid = sid;
		this.sname = sname;
	}
	
	@Column(name="STUDENT_ID")
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Id
	@Column(name="STUDENT_Name")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}


