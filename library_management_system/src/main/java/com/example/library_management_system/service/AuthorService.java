package com.example.library_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.AuthorDao;
import com.example.library_management_system.dto.Author;
import com.example.library_management_system.exception.AuthorException;
import com.example.library_management_system.util.ResponseStructure;

@Service
public class AuthorService {
	@Autowired
	private AuthorDao authordao;
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author)  {
		ResponseStructure<Author> structure= new ResponseStructure<Author>();
		Author author1=  authordao.saveAuthor(author);
		     if(author1!=null) {
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(author1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new AuthorException("Book not added");
		     }
	}
	public ResponseEntity<ResponseStructure<Author>> findAuthor(int id)  {
		ResponseStructure<Author> structure= new ResponseStructure<Author>();
		Author author1=  authordao.findAuthor(id);
		     if(author1!=null) {
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(author1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new AuthorException("Book not found");
		     }
	}
	public List<Author> getAllAuthorss()  {
		     List<Author> authorist= authordao.findAllAuthors();
		    if(authorist!=null) {
		    	return authorist;
		    }else {
		    	return null;
		    }
	}
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(int id)  {
		ResponseStructure<Author> structure= new ResponseStructure<Author>();
		Author author1=  authordao.findAuthor(id);
		     if(author1!=null) {
		    	 authordao.deleteAuthor(id);
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(author1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new AuthorException("Book not deleted");
		     }
	}
	

}
