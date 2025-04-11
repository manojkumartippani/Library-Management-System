package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.dto.Author;
import com.example.library_management_system.repo.AuthorRepo;

@Repository
public class AuthorDao {
	@Autowired
	private AuthorRepo authorrepo;
	
	public Author saveAuthor(Author author) {
	    return authorrepo.save(author);
	}
	public Author findAuthor(int id) {
		Optional<Author> book1=authorrepo.findById(id);
		if(book1.isPresent()) {
			return book1.get();
		}else {
			return null;
		}
	}
	public List<Author> findAllAuthors(){
		return authorrepo.findAll();
	}
	public void deleteAuthor(int id) {
		authorrepo.deleteById(id);
	}

}
