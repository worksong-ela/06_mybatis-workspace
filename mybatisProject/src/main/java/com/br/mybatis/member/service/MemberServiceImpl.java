package com.br.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.br.mybatis.common.template.Template.getSqlSession;
import com.br.mybatis.member.dao.MemberDao;
import com.br.mybatis.member.dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao = new MemberDao();

	@Override
	public MemberDto selectMember(int userNo) {
		SqlSession sqlSession = getSqlSession();
		MemberDto m = memberDao.selectMember(sqlSession, userNo);
		sqlSession.close();
		return m;
	}

	@Override
	public int updateMember(MemberDto m) {
		SqlSession sqlSession = getSqlSession();
		int result = memberDao.updateMember(sqlSession, m);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

}
