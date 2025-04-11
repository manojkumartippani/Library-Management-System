package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.dto.Member;
import com.example.library_management_system.repo.MemberRepo;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepo memberrepo;
	
	public Member saveMember(Member member) {
	    return memberrepo.save(member);
	}
	public Member findMember(int id) {
		Optional<Member> member1=memberrepo.findById(id);
		if(member1.isPresent()) {
			return member1.get();
		}else {
			return null;
		}
	}
	public List<Member> findAllMember(){
		return memberrepo.findAll();
	}
	public void deleteMember(int id) {
		memberrepo.deleteById(id);
	}

}
