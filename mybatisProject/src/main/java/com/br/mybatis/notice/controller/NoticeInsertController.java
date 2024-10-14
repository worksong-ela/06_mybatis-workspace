package com.br.mybatis.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.mybatis.notice.dto.NoticeDto;
import com.br.mybatis.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// request로부터 제목과 내용을 뽑아서 Notice 객체에 주섬주섬 담아서 통채로 넘겨야한다
		
		NoticeDto n = new NoticeDto(); // Notice객체 생성
		n.setNoticeTitle(request.getParameter("title")); // n이라는 Notice 객체에 Title이라는 필드가 있는데,
														 // 여기에 요청시 전달된 제목값을 담을거다. 
													     //그 제목값은 request로부터 getParameter로 "title"이라는 
														 // 키값으로 넘어온 데이터를 꺼내서 NoticeTitle에 담는다.
		n.setNoticeContent(request.getParameter("content"));
		//n.setNoticeWriter(세션에 담겨있는 로그인한 회원의 회원번호);
		n.setNoticeWriter("1"); // 1번 회원이라는 가정하에
		
		int result = new NoticeServiceImpl().insertNotice(n);
		
		if(result > 0) {
			System.out.println("공지사항 등록 성공");
			response.sendRedirect(request.getContextPath());
		}else {
			System.out.println("공지사항 등록 실패");
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
