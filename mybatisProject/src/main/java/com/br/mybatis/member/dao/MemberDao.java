package com.br.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.member.dto.MemberDto;

public class MemberDao {
	
	public MemberDto selectMember(SqlSession sqlSession, int userNo) {
		return sqlSession.selectOne("memberMapper.selectMember", userNo);
	}

	public int updateMember(SqlSession sqlSession, MemberDto m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}
}
