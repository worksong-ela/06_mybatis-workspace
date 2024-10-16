package com.br.mybatis.notice.service;

import static com.br.mybatis.common.template.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.common.dto.PageInfoDto;
import com.br.mybatis.notice.dao.NoticeDao;
import com.br.mybatis.notice.dto.NoticeDto;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao = new NoticeDao();
	// Dao측 메소드를 호출할 거라서 Dao측 객체는 전역변수로 생성해뒀었음
	// 전역변수로 noticeDao를 생성한다.

	@Override
	public int insertNotice(NoticeDto n) {
		
		SqlSession sqlSession = /*Template.*/getSqlSession();
		// Template 클래스에 getSqlSession 메소드를 만들어뒀다.
		// getSqlSession 메소드는 mybatis-config.xml 문서를 읽어들이면서 DB와 연결된다.
		// Template. 을 생략하고 싶다면 import문에 static 적어주고 맨오른쪽에 .getSqlSession 적어준다.
		// sqlSession 객체는 mybatis용 객체다. 이걸 가지고 쿼리 실행, 트랜젝션 처리, 클로즈처리 등을 한다
		
		int result = noticeDao.insertNotice(sqlSession, n); // n은 insert한 데이터들이 담긴 notice 객체
		// mapper의 insert문이 실행되고, 처리된 행수가 NoticeDao로 갔고,
		// 그게 return 되어서 여기 이 자리로 반환된거다.
		
		if(result > 0) { // Dao에서 반환된 행수 결과인 result의 결과 확인
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	
	
	@Override
	public NoticeDto selectNotice(int noticeNo) {
		
		SqlSession sqlSession = getSqlSession();
		NoticeDto n = noticeDao.selectNotice(sqlSession, noticeNo);
		
		sqlSession.close();
		return n;
	}

	@Override
	public List<NoticeDto> selectList() {
		
		SqlSession sqlSession = getSqlSession();
		List<NoticeDto> list = noticeDao.selectList(sqlSession);
		sqlSession.close();
		return list;
	}

	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		int listCount = noticeDao.selectListCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public List<NoticeDto> selectList(PageInfoDto pi) {
		SqlSession sqlSession = getSqlSession();
		List<NoticeDto> list = noticeDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

}
