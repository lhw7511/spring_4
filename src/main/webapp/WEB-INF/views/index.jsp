<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<title>Home</title>
	<c:import url="./template/bootStrap.jsp"></c:import>
</head>
<body>

<c:import url="./template/header.jsp"></c:import>


<div class="container">
  
  <h3>Home</h3>
<div>
	<c:if test="${not empty member}">
		<h1>로그인 성공</h1>
	</c:if>
	
	<c:if test="${ empty member}">
		<h1>로그인 실패</h1>
	</c:if>
	<img alt="main image" src="./resources/images/index/naeun.jpg">
	
	<a href="./cookie/makeCookie">MakeCookie</a>
</div>
</div>
</body>
</html>
