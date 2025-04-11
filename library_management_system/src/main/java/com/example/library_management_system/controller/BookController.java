package com.example.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.dto.Book;
import com.example.library_management_system.service.BookService;
import com.example.library_management_system.util.ResponseStructure;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/savebook")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book){
		return bookService.saveBook(book);
	}
	
	@GetMapping("/findbook/{id}")
	public ResponseEntity<ResponseStructure<Book>> findBook(@PathVariable int id)  {
		return bookService.findBook(id);
	}
	@GetMapping("/findallbooks")
	public List<Book> findAllBooks()  {
		return bookService.findAllBooks();
	}
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id)  {
		return bookService.deleteBook(id);
	}

}
