package com.My.Library.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService 
{		
	public List<Book> books = new ArrayList<>(Arrays.asList(
			new Book("DS","Data Structure"),
			new Book("DB","Data Base"),
			new Book("ADA","Algorithm design and analysis"),
			new Book("LD","Logic Design"),
			new Book("JAVA","Introduction to Java"),
			new Book("CPP","Object Oriented Programming")));
		
	public List<Book> getAllBooks() 
	{
		return books;
	}
	
	public Book getLBook(String id)
	{
		return books.stream().filter(t-> t.getId().equals(id)).findFirst().get(); 
	}
	
	public void addLBook(Book book)
	{
		books.add(book);
	}
	
	public void updateLBook(String id,Book book)
	{
		for(int i=0;i<books.size();i++)
		{
			Book t = books.get(i);
			if(t.getId().equals(id))
			{
				books.set(i,book);
				return;
			}
		}
	}
	
	public void deleteLBook(String id)
	{
		books.removeIf(t->t.getId().equals(id));
	}
}
