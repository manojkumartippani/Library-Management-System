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

import com.example.library_management_system.dto.Book;
import com.example.library_management_system.dto.Member;
import com.example.library_management_system.service.MemberService;
import com.example.library_management_system.util.ResponseStructure;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberser;
	
	@PostMapping("/savemember")
	public ResponseEntity<ResponseStructure<Member>> saveMember(@RequestBody Member member)  {
		return memberser.saveMember(member);
	}
	@GetMapping("/findmember/{id}")
	public ResponseEntity<ResponseStructure<Member>> findMember(@PathVariable int id)  {
		return memberser.findMember(id);
	}
	@GetMapping("/getmembers")
	public List<Member> getAllMembers()  {
		return memberser.getAllMembers();
	}
	@DeleteMapping("/deletemember/{id}")
	public ResponseEntity<ResponseStructure<Member>> deleteMember(@PathVariable int id)  {
		return memberser.deleteMember(id);
	}
	
	@PostMapping("/addbook/{id}")
	public ResponseEntity<ResponseStructure<Member>> addBookToMember(@PathVariable int id, @RequestBody Book book)  {
		return memberser.addbooktoauthor(id, book);
	}
}
