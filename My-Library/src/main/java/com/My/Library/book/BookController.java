package com.My.Library.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@RequestMapping("books/{id}")
	public Book getLBook(@PathVariable String id)
	{
		return bookService.getLBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/books")
	public void addLBook(@RequestBody Book book)
	{
		bookService.addLBook(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/books/{id}")
	public void updateLBook(@RequestBody Book book,@PathVariable String id)
	{
		bookService.updateLBook(id,book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/books/{id}")
	public void deleteLBook(@PathVariable String id)
	{
		bookService.deleteLBook(id);
	}
}







