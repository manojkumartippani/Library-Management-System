package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.dto.Book;
import com.example.library_management_system.repo.BookRepo;

@Repository
public class BookDao {
	@Autowired
	private BookRepo bookrepo;
	
	public Book saveBook(Book book) {
	    return bookrepo.save(book);
	}
	public Book findBook(int id) {
		Optional<Book> book1=bookrepo.findById(id);
		if(book1.isPresent()) {
			return book1.get();
		}else {
			return null;
		}
	}
	public List<Book> findAllBooks(){
		return bookrepo.findAll();
	}
	public void deleteBook(int id) {
		bookrepo.deleteById(id);
	}

}
