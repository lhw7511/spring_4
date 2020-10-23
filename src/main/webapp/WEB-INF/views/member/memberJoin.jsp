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
	<h3>Member Join Page</h3>
	<form action="./memberJoin" method="post" id="frm">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
    
     <div class="form-group">
      <label for="pw">Password Check:</label>
      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pwCheck">
    </div>
    
     <div class="form-group">
      <label for="name">NAME:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    
     <div class="form-group">
      <label for="email">EMAIL:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
        <button type="button" class="btn btn-default" id="btn">Submit</button>
  </form>
	</div>
	<script type="text/javascript">
	  $("#btn").click(function(){
		 var t=	$("#id").length;
		 var p=	$("#pw").length;
		 var p2=$("#pw2").length;
		 var n= $("#name").length;
		 var e= $("#email").length;	 
		 var check =false;
		 if(t!=0&&p!=0&&n!=0&&e!=0&&p2!=0){
			 check=true;
		 }
		 
		 var a = $("#pw").val();
		 var b=  $("#pw2").val();
		 if(a==b&&check){
			 $("#frm").submit();
		 }else if(a!=b&&check){
			 alert("비밀번호가 일치하는지 확인해주세요");
		 }else if(!check){
			 alert("필수 항목을 입력해주세요");
		 }
	  });
	
	</script>
</body>
</html>