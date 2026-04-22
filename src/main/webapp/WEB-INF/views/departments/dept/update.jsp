<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 정보 수정</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="departmentId" value="${dto.departmentId}">
		<div>
			<label>부서명</label>
			<!-- DTO의 setter의 이름과 동일하게 -->
			<input type="text" value="${dto.departmentName}" placeholder="부서명 입력" name="departmentName">
		</div>
		<div>
			<label>관리자코드</label>
			<input type="text" name="managerId" value="${dto.managerId}" placeholder="숫자만입력">
		</div>
		
		<div>
			<label>지역코드</label>
			<input type="text" name="locationId" value="${dto.locationId}">
		</div>
		<button type="submit">button</button>
		<input type="submit" value="create">		
		<input type="button" value="등록">
		<input type="reset" value="reset">
	
	</form>
	
</body>
</html>