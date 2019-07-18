package com.My.Library.studentbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.My.Library.book.Book;
import com.My.Library.book.BookService;
import com.My.Library.student.Student;
import com.My.Library.student.StudentService;

@RestController
public class SbookController 
{
	@Autowired
	private SbookService sbookService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/students/books")
	public List<Sbook> getStudentAllBooks()
	{
		return sbookService.getStudentAllBooks();
	}
	
	@RequestMapping("/students/books/{id}")
	public Sbook getStudentBook(@PathVariable String id)
	{
		return sbookService.getStudentBook(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/students/{studentId}/books/{bookId}")
	public void addBook(@RequestBody Sbook s,@PathVariable String studentId,@PathVariable String bookId)
	{
		for(int i=0;i<studentService.students.size();i++)
		{
			Student t = studentService.students.get(i);
			if(t.getSid().equals(studentId))
			{
				for(int j=0;j<bookService.books.size();j++)
				{
					Book k = bookService.books.get(j); 
					if(k.getId().equals(bookId)) 
					{
						s.setStudent(new Student(studentId));
						s.setBook(new Book(bookId)); 
						sbookService.addBook(s);
						return;
					}
				}
			}
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/students/{studentId}/books/{bookId}/{id}")
	public void updateBook(@RequestBody Sbook s,@PathVariable String studentId,@PathVariable String bookId,@PathVariable String id)
	{
		for(int i=0;i<studentService.students.size();i++)
		{
			Student t = studentService.students.get(i);
			if(t.getSid().equals(studentId))
			{
				for(int j=0;j<bookService.books.size();j++)
				{
					Book k = bookService.books.get(j);
					if(k.getId().equals(bookId)) 
					{
						s.setStudent(new Student(studentId));
						s.setBook(new Book(bookId));
						sbookService.updateBook(id,s);
						return;
					}
				}
			}
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/students/{studentId}/books/{Id}")
	public void deleteBook(@PathVariable String Id)
	{
		sbookService.deleteBook(Id);
	}
}



