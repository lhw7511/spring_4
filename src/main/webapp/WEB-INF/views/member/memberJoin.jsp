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
      <div id="idResult"></div>
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
		 var t=	$("#id").val().length;
		 var p=	$("#pw").val()
		 var p2=$("#pw2").val()
		 var n= $("#name").val().length;
		 var e= $("#email").val().length;	 
	   
		 var check =false;
		 if(t!=0&&p.length!=0&&n!=0&&e!=0&&p2.length!=0){
			 check=true;
		 }
		 
		
		 if(p==p2&&check){
			 $("#frm").submit();
		 }else if(p!=p2&&check){
			 alert("비밀번호가 일치하는지 확인해주세요");
		 }else{
			 alert("필수 항목을 입력해주세요");
		 }
	  });
	
	  $("#id").focusout(function(){
		 $.post("./memberIdCheck",{id: $("#id").val()},function(data){
			data=data.trim();
			if(data==1){
				  $("#idResult").text("사용가능한 아이디입니다");
				  $("#idResult").css("color","blue");
			  }else{
				  $("#idResult").text("중복된 아이디입니다");
				  $("#idResult").css("color","red");
			  }
			  
		 });
	  });
	  
	</script>
</body>
</html>