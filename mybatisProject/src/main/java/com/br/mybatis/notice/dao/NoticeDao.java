package com.br.mybatis.notice.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.common.dto.PageInfoDto;
import com.br.mybatis.notice.dto.NoticeDto;

public class NoticeDao {
	
	public int insertNotice(SqlSession sqlSession, NoticeDto n) { 
		// n에는 Controller의 NoticeTitle, NoticeContent, NoticeWriter 필드에 insert할 데이터들이 담겨있다
		// 이것들을 가지고 실행할 sql문은 notice-mapper.xml에 적어준다
		return sqlSession.insert("noticeMapper.insertNotice", n);
		// 여기서 n은 mapper 메소드부분에서 물음표부분을 완성시킬 때 필요한 noticeDto 객체 n을 넘겨주는것
	}
	
	public int updateNotice(SqlSession sqlSession, NoticeDto n) {
		return sqlSession.update("noticeMapper.updateNotice", n);
	}
	
	public int deleteNotice(SqlSession sqlSession, int noticeNo) {
		return sqlSession.delete("noticeMapper.deleteNotice", noticeNo);
	}
	
	public NoticeDto selectNotice(SqlSession sqlSession, int noticeNo) {
		return sqlSession.selectOne("noticeMapper.selectNotice", noticeNo);
	}
	
	public List<NoticeDto> selectList(SqlSession sqlSession){
		return sqlSession.selectList("noticeMapper.selectList");
	}
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("noticeMapper.selectListCount");
	}
	
	public List<NoticeDto> selectList(SqlSession sqlSession, PageInfoDto pi){
		//sqlSession.selectList("noticeMapper.selectList")
		
		/*
		 * * RowBounds 
		 *   1. 마이바티스에서 페이징 처리를 위해 제공하는 객체
		 *   2. 조회되는 데이터들 중 몇개를 건너띄고 몇개 조회할껀지 세팅해둘 수 있는 객체
		 *   3. RowBounds rowBounds = new RowBounds(offset, limit);
		 *   	 ㄴ offset : 건너띌 갯수
		 *   	 ㄴ limit  : 조회할 갯수
		 *   
		 *   따라서 쿼리문은 그냥 전체 게시글 조회하는 쿼리문을 쓰되
		 *   RowBounds 사용해서 일부 게시글을 걸러서 조회 
		 *   
		 *   							offset    limit
		 *   currentPage : 1    1~5		  0			5
		 *   currentPage : 2    6~10	  5			5
		 *   currentPage : 3   11~15	  10	    5
		 *   
		 */
		
		int limit =  pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("noticeMapper.selectList", null, rowBounds);
	}
	
	
	
	
	
	

}
