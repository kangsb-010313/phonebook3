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
		
		<h2>전화번호 리스트</h2>
		<p>전화번호 리스트 입니다.</p>
		
	
		<c:forEach items="${requestScope.pList}" var="personVO">
			<table border = "1">
				<tbody>
					<tr>
						<td>이름(name)</td>
						<td>
							${personVO.name}
						</td>
					</tr>
					<tr>
						<td>핸드폰(hp)</td>
						<td>${personVO.hp}</td>
					</tr>
					<tr>
						<td>회사(company)</td>
						<td>${personVO.company}</td>
					</tr>
					<tr>
						<td>
							<a href = "http://localhost:8080/pbook3/pbc?action=mform&no=">
								[수정폼으로 이동]
							</a>
						</td>
						<td>
							<a href= "http://localhost:8080/pbook3/pbc?action=delete&no=">
							[삭제]
							</a>
						</td>	 <!-- 원래 버튼으로 해야된다. 자바스크립트필요. 안배워서 a태그로 구현 -->
					</tr>
				</tbody>
			
			</table>
			<br>
		</c:forEach>

		
		[주소록 작성폼 이동] : 주소창에 aaa.html 입력하시고 엔터입력
		<br>
		<a href= "http://localhost:8080/pbook3/pbc?action=wform">주소록 작성폼 이동</a>

	

	</body>
</html>