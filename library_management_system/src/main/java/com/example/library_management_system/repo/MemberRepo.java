package com.example.library_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management_system.dto.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{

}
