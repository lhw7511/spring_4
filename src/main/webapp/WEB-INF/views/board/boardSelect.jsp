<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div>
	<h2>${board} Select Page</h2>
  <h3 id="num">NUM : ${select.num}</h3>
  <h3 id="title">TITLE : ${select.title}</h3>
  <h3 id="writer">WRITER : ${select.writer}</h3>
  <h3 id="contents">CONTENTS : ${select.contents}</h3>
  <h3>REDATE : ${select.regDate}</h3>
  <h3>HIT : ${select.hit}</h3> 
  <input type="button" value="DELETE" title="${select.num}" class="btn btn-warning" id="del">  
  <input type="button" value="UPDATE" title="${select.num}" class="btn btn-warning" id="UP">
  <c:if test="${board ne 'notice'}">
   <a class="btn btn-primary" href="./${board}Reply?num=${select.num}">Reply</a> 
   </c:if>
</div>
<script type="text/javascript">
$("#del").click(function(){
	//var num =$("#num").html();
	var num =$("#del").attr("title");
	location.href="./${board}Delete?num="+num;
});

$("#UP").click(function(){
	var num =${select.num};

	location.href="./${board}Update?num="+num;
});
</script>
</body>

</html>