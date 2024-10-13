package com.br.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존의 JDBCTemplate
	 * 
	 * public static Connection getConnection() {
	 * 		driver.properties 파일 읽어들이면서
	 * 		해당 db와 접속된 Connection 생성해서 반환 
	 * }
	 * 
	 * public static void close(JDBC용 객체) {
	 * 		전달받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static void commit|rollback(Connection 객체) {
	 * 		트랜잭션 처리 
	 * }
	 */
	
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 파일 읽어들여서
		// 해당 db와 접속된 SqlSession 객체 생성해서 반환 
		
		SqlSession sqlSession = null; // 예외처리 할거라서 일단 null 처리를 해둔다
		
		try {
			InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // inputStream 객체 생성
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
			// openSession의 false : auto commit을 안하겠다는 의미 즉, 개발자가 직접 commit 하겠다는 뜻
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
	}

}
