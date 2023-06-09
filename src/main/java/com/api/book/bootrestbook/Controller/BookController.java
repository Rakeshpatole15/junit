package com.api.book.bootrestbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.service.BookService;




@RestController
public class BookController {
	
	@Autowired  
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return this.bookService.getAllBooks();
		
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id ) {
		
		return bookService.getBookById(id);
		
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		this.bookService.addBook(book);
		System.out.println(book);
		return book;
		
	}
	
	//Delet Book Controller
	
	@DeleteMapping("/books/{bookId}")
	public void deletBook(@PathVariable("bookId") int bookId) {
		
		this.bookService.deletBook(bookId); 
		
	}
	
	
	//Update the Book
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book ,@PathVariable("bookId") int bookId) {
		
		this.bookService.updateBook(book, bookId);
		return book;
		
	}
	
	
	
	
	
	
	
	
	

	

}
