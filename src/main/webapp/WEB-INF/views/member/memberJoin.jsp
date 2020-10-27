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
	<form action="./memberJoin" method="post" id="frm" enctype="multipart/form-data">
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
    <div id="pwCheck" ></div>
     <div class="form-group">
      <label for="name">NAME:</label>
      <input type="text" class="form-control " id="name" placeholder="Enter name" name="name">
    </div>
     <div id="nameCheck" ></div>
     <div class="form-group">
      <label for="email">EMAIL:</label>
      <input type="text" class="form-control " id="email" placeholder="Enter email" name="email">
    </div>
    
     <div id="emailCheck" ></div>
      <div class="form-group">
      <label for="photo">Photo:</label>
      <input type="file" class="form-control " id="photo" name="photo">
    </div>
     
        <button type="button" class="btn btn-default" id="btn">Submit</button>
  </form>
	</div>
	<script type="text/javascript">
		var idCheck=false;
		var pwCheck=false;
		var nameCheck=false;
		var emailCheck=false;
		
	  $("#name").blur(function(){
		  nameCheck=false;
		 	if($(this).val().length==0){
		 		 $("#nameCheck").text("이름을 입력해주세요");
				  $("#nameCheck").css("color","red");
		 	}else{
		 		 $("#nameCheck").text("");
		 		 nameCheck=true;
		 	}
	  });
	  $("#email").blur(function(){
		  emailCheck=false;
		 	if($(this).val().length==0){
		 		 $("#emailCheck").text("이메일을 입력해주세요");
				  $("#emailCheck").css("color","red");
		 	}else{
		 		 $("#emailCheck").text("");
		 		emailCheck=true;
		 	}
	  });	
	  $("#btn").click(function(){
		
		if(idCheck&&pwCheck&&nameCheck&&emailCheck){
			$("#frm").submit();
		}
		
		
		 
	  });
	
	  $("#id").blur(function(){
		  idCheck=false;
		   var id=$(this).val();
		  if(id.length==0){
			  $("#idResult").text("id를입력해주세요");
			  $("#idResult").css("color","red");
		  }else{
			  $.post("./memberIdCheck",{id: $(this).val()},function(data){
					
					data=data.trim();
					
					
						if(data==1){
							  $("#idResult").text("사용가능한 아이디입니다");
							  $("#idResult").css("color","blue");
							  idCheck=true;
						  }else{
							  $("#idResult").text("중복된 아이디입니다");
							  $("#idResult").css("color","red");
							 
						  }
					
					
					  
				 }); 
		  }
		
	  });
	  
	  $("#pw2").blur(function(){
		   var pw =$("#pw").val();
		   var pw2=$(this).val();
		   pwCheck=false;
		   if(pw2.length==0){
			   $("#pwCheck").text("비밀번호를 입력해주세요");
			   $("#pwCheck").css("color","red");
		   }else{
			   if(pw==pw2){
				   $("#pwCheck").text("비밀번호가 일치합니다");
				   $("#pwCheck").css("color","blue");
				   pwCheck=true;
			   }else{
				   $("#pwCheck").text("비밀번호가 일치하지않습니다");
				   $("#pwCheck").css("color","red");
			   }
		   }
		   
		   
	  })
	</script>
</body>
</html>