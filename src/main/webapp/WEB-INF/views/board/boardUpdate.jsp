<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

<style type="text/css">
 d1{
 	display: none;
 }
</style>
</head>
<body>
	<c:import url="../template/header.jsp">

</c:import>

<div class="container">
  <h2>${board} Update form</h2>
  <form action="./${board}Update"method="post" id="frm">
  	<div class="form-group" id="d1">
      
      <input type="hidden" class="form-control" id="num"  name="num" value = "${dto.num}" >
    </div>
  
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" value = "${dto.title}">
    </div>
    
  <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${dto.writer}" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="contents">Contents:</label>
     	<textarea class="form-control" rows="10" id="contents" name="contents" >${dto.contents}</textarea>
    </div>
    
   	<input type="button" class="btn btn-primary" value="UPDATE" id="btn">
    
  </form>
</div>
<script type="text/javascript" src="../resources/js/boardWrite.js"></script>
</body>
</html>