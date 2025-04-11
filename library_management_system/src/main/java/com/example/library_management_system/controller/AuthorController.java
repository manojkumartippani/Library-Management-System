package com.example.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.dto.Author;
import com.example.library_management_system.service.AuthorService;
import com.example.library_management_system.util.ResponseStructure;

@RestController
public class AuthorController {
	@Autowired
	private AuthorService authorser;
	
	@PostMapping("/saveauthor")
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author author)  {
		return authorser.saveAuthor(author);
	}
	@GetMapping("/findauthor/{id}")
	public ResponseEntity<ResponseStructure<Author>> findBook(@PathVariable int id)  {
		return authorser.findAuthor(id);
	}
	@GetMapping("/getauthors")
	public List<Author> getAllAuthorss()  {
		return authorser.getAllAuthorss();
	}
	@DeleteMapping("/deleteauthor/{id}")
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(@PathVariable int id)  {
		return authorser.deleteAuthor(id);
	}

}
