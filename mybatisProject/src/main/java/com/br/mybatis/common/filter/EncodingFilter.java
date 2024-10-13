package com.br.mybatis.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 * 
 * 어떤 서블릿이 실행되기 전에 매번 공통적으로 실행해야되는 구문이 있을 경우
 * 필터로 한번 정의해두고 해당 필터를 거쳐가게끔 등록가능 
 * => 매 서블릿마다 중복된 코드를 작성할 필요 없음 
 * 
 * * 필터 등록하는 방법
 *   1. web.xml 에 등록하는 방법
 *   2. 어노테이션을 이용해서 등록하는 방법
 */
@WebFilter(filterName="encodingFilter", urlPatterns="/*")
public class EncodingFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Servlet 실행전에 공통적으로 실행시킬 코드 
		// => 요청전송방식이 post방식일 경우 utf-8 로 인코딩 처리
		if( ((HttpServletRequest)request).getMethod().equalsIgnoreCase("post") ) {
			request.setCharacterEncoding("utf-8");
		}
		
		
		chain.doFilter(request, response); // 다음 필터를 호출 | 서블릿 호출 
		
		
		// Servlet 실행후에 공통적으로 실행시킬 코드 
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
