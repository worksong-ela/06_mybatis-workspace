package com.br.mybatis.notice.service;

import java.util.List;

import com.br.mybatis.common.dto.PageInfoDto;
import com.br.mybatis.notice.dto.NoticeDto;

public interface NoticeService {
	
	// 모든 메소드들은 추상메소드로 작성 == 묵시적으로 public abstract
	
	// interface 클래스를 나중에 implements 해서 여기에 써 있는 메소드들을 사용할 예정
	
	// 공지사항 등록 
	int insertNotice(NoticeDto n); // insert 할 공지사항 제목이라던가 내용 등이 담길 NoticeDto n
	
	// 공지사항 상세조회 
	NoticeDto selectNotice(int noticeNo); // 조회하고자하는 글번호같은걸 넘겨 받아야하므로 int noticeNo라고 적음
	
	// 공지사항 목록조회 (페이징 x)
	List<NoticeDto> selectList();
	
	// 공지사항 목록조회 (페이징 o)
	int selectListCount();
	List<NoticeDto> selectList(PageInfoDto pi);	// 여러행 조회라 List
												// 페이징처리라 사용자가 몇번 페이지를 요청했고, 게시글을 몇개 조회해가야하는지에 대한 pageinfo 객체가 필요

}
