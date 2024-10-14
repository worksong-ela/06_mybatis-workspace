<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>공지사항 등록</h2>
	
	<form action="${ contextPath }/insert.no" method="post"> <%-- 요청할 url은 contextPath 뒤에 적혀야한다. 그 url에 title이라는 키값으로 제목과 content라는 키값으로 내용이 넘겨진다  --%>
																													 <%-- insert.no 라는 url 매핑값을 가지는 Servlet인 Controller를 만들어야한다 --%>
		제목 : <input type="text" name="title"> <br> <%-- input에 키값(name) 부여해야 값이 넘어간다 --%>
		내용 : <textarea name="content"></textarea> <br><br> <%-- 이것도 마찬가지로 키값(name)이 부여돼있어야한다 --%>
		
		<button type="submit">등록하기</button>
	</form>

</body>
</html>