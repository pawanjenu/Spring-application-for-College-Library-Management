package com.My.Library.studentbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class SbookService 
{
	
	public List<Sbook> sbooks = new ArrayList<>(Arrays.asList());
	
	public List<Sbook> getStudentAllBooks() 
	{
		return sbooks;
	}
	
	public Sbook getStudentBook(String id)
	{
		return sbooks.stream().filter(t-> t.getSb().equals(id)).findFirst().get(); 
	}
	
	public void addBook(Sbook sbook)
	{
		sbooks.add(sbook);
	}
	
	public void updateBook(String id,Sbook sbook)
	{
		for(int i=0;i<sbooks.size();i++)
		{
			Sbook t = sbooks.get(i);
			if(t.getSb().equals(id))
			{
				sbooks.set(i,sbook);
				return;
			}
		}
	}
	
	public void deleteBook(String id)
	{
		sbooks.removeIf(t->t.getSb().equals(id)); 
	}
}
