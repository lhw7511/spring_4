<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		<table class="table">
			<tr> 
				<th>Num</th> <td>${member.num}</td>										
			</tr>	
			<tr>
				<th>ID</th> <td>${member.id}</td>
			</tr>		
			<tr>
				<th>NAME</th> <td>${member.name}</td>
			</tr>
			<tr>
				<th>Email</th> <td>${member.email}</td>
			</tr>
		</table>
		<div>
			<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
		</div>
		<a href="./memberUpdate" class="btn btn-primary">UPDATE</a>
		<a href="./memberDelete" class="btn btn-danger">DELETE</a>
	</div>
</body>
</html>