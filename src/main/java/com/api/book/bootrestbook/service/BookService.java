package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;


@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		
		list.add(new Book(12,"Java Complete Reference","XYZ"));
		list.add(new Book(13,"learn Java","MNL"));
		list.add(new Book(14,"Think in Java","ABC"));
		list.add(new Book(15,"Think in python","MRP"));
		list.add(new Book(16,"Think in Cotlin","STU"));
	
	}
	
	
	//get All Books
	public List<Book> getAllBooks(){
		
		return list;
		
	}
	
	
	//Get Book By ID
	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//Adding the Book 
	public void addBook(Book b) {
		
		list.add(b);
	}

    // Deleting the book
	public void deletBook(int bookId) {
		// TODO Auto-generated method stub
		
		list=list.stream().filter(book-> book.getId()!=bookId).collect(Collectors.toList());
		
	}

    //Updating the book
	public void updateBook(Book book, int bookId) {
		
		list =list.stream().map(b->{
			
			if(b.getId()==bookId) {
				
				b.setTitle(book.getTitle());
				b.setAuther(book.getAuther());
			}
			
			return b;
		}).collect(Collectors.toList());
		
	}

}
