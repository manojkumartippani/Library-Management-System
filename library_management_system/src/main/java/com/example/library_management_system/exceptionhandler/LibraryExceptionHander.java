package com.example.library_management_system.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.library_management_system.exception.AuthorException;
import com.example.library_management_system.exception.BookException;
import com.example.library_management_system.exception.MemberException;
import com.example.library_management_system.util.ResponseStructure;



@RestControllerAdvice
public class LibraryExceptionHander{
	
	ResponseStructure<String> responseStructure=new ResponseStructure<String>();
	@ExceptionHandler(BookException.class)
	public ResponseEntity<ResponseStructure<String>> InvalidEmail(BookException bookException){
		responseStructure.setData(bookException.getMessage());
		responseStructure.setMessage("Exception");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(AuthorException.class)
	public ResponseEntity<ResponseStructure<String>> InvalidEmail(AuthorException bookException){
		responseStructure.setData(bookException.getMessage());
		responseStructure.setMessage("Exception");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<ResponseStructure<String>> InvalidEmail(MemberException bookException){
		responseStructure.setData(bookException.getMessage());
		responseStructure.setMessage("Exception");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}



}
