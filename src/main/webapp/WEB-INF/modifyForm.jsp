<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>주소록</h1>
		
		<h2>전화번호 수정폼</h2>
		<p>전화번호를 수정하는 폼입니다.</p>
		
		<form action="${pageContext.request.contextPath}/pbc" method="get">
			<label>이름(name): </label>
			<input type= "text" name="name" value="${requestScope.personVo.name}">
			<br>
			
			<label>핸드폰(hp): </label>
			<input type= "text" name="hp" value="${personVo.hp}">
			<br>
			
			<label>회사(company): </label>
			<input type= "text" name="company" value="${personVo.company}">
			<br>

			
			<input type= "text" name="person_id" value="${personVo.personId}">
			<input type= "text" name="action" value="modify">
			<br>
			
			<button>수정</button>
			
		</form>
	</body>
	
</html>