package com.example.library_management_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.MemberDao;
import com.example.library_management_system.dto.Book;
import com.example.library_management_system.dto.Member;
import com.example.library_management_system.exception.MemberException;
import com.example.library_management_system.util.ResponseStructure;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberdao;
	
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member)  {
		ResponseStructure<Member> structure= new ResponseStructure<Member>();
		Member member1=  memberdao.saveMember(member);
		     if(member1!=null) {
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(member1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new MemberException("Book not added");
		     }
	}
	public ResponseEntity<ResponseStructure<Member>> findMember(int id)  {
		ResponseStructure<Member> structure= new ResponseStructure<Member>();
		Member member1=  memberdao.findMember(id);
		     if(member1!=null) {
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(member1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new MemberException("Book not found");
		     }
	}
	public List<Member> getAllMembers()  {
		     List<Member> memberist= memberdao.findAllMember();
		    if(memberist!=null) {
		    	return memberist;
		    }else {
		    	return null;
		    }
	}
	public ResponseEntity<ResponseStructure<Member>> deleteMember(int id)  {
		ResponseStructure<Member> structure= new ResponseStructure<Member>();
		Member member1=  memberdao.findMember(id);
		member1.setBooks(null);
		memberdao.saveMember(member1);
		     if(member1!=null) {
		    	 memberdao.deleteMember(id);
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(member1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new MemberException("Book not deleted");
		     }
	}
	public ResponseEntity<ResponseStructure<Member>> addbooktoauthor(int id,Book book)  {
		ResponseStructure<Member> structure= new ResponseStructure<Member>();
		Member member1=  memberdao.findMember(id);
		List<Book> book1=new ArrayList<Book>();
		book1.add(book);
		member1.setBooks(book1);
		     if(member1!=null) {
		    	 memberdao.saveMember(member1);
		    	 structure.setStatus(HttpStatus.ACCEPTED.value());
		    	 structure.setData(member1);
		    	 structure.setMessage("successfull");
		    	 return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.ACCEPTED);
		     }else {
		    	 throw new MemberException("Book not found");
		     }
	}
	


}
