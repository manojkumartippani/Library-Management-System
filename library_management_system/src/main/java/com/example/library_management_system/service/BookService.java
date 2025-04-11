package com.example.library_management_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.BookDao;
import com.example.library_management_system.dto.Book;
import com.example.library_management_system.exception.BookException;
import com.example.library_management_system.util.ResponseStructure;




@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book)  {
		ResponseStructure<Book> structure= new ResponseStructure<Book>();
		     Book book1=  bookDao.saveBook(book);
		     if(book1!=null) {
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(book1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new BookException("Book not added");
		     }
	}
	public ResponseEntity<ResponseStructure<Book>> findBook(int id)  {
		ResponseStructure<Book> structure= new ResponseStructure<Book>();
		     Book book1=  bookDao.findBook(id);
		     if(book1!=null) {
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(book1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new BookException("Book not found");
		     }
	}
	public List<Book> findAllBooks()  {
		     List<Book> bookist= bookDao.findAllBooks();
		    if(bookist!=null) {
		    	return bookist;
		    }else {
		    	return null;
		    }
	}
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id)  {
		ResponseStructure<Book> structure= new ResponseStructure<Book>();
		     Book book1=  bookDao.findBook(id);
		     if(book1!=null) {
		    	 bookDao.deleteBook(id);
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(book1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new BookException("Book not deleted");
		     }
	}
	

}
