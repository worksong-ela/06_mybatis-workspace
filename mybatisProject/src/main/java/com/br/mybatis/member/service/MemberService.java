package com.br.mybatis.member.service;

import com.br.mybatis.member.dto.MemberDto;

public interface MemberService {

	// 회원정보 상세조회
	MemberDto selectMember(int userNo);
	
	// 회원정보 변경
	int updateMember(MemberDto m);
	
	// 회원 검색 
	
	
	
}
