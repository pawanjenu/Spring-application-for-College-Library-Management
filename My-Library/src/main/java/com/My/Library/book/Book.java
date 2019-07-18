package com.My.Library.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="BOOK")
public class Book 
{
	private String id;
	private String name; 
	

	public Book(){}
	
	public Book(String id)
	{
		super();
		this.id = id;
	}
	
	public Book(String id,String name)   //Hard coded...
	{
		super();
		this.id = id;
		this.name = name;
	}
	
	
	@Id
	@Column(name = "BOOK_ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "BOOK_NAME",nullable=false) 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
