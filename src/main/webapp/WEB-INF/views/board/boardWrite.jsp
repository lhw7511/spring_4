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
	#f{
	 display: none;
	}
    .del {
        color: red;
        font-weight: bold;
        cursor: pointer;
    }
</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h2>${board} Write form</h2>
  <form action="./${board}Write"method="post" id="frm"enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
    </div>
    
     <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${member.id}" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="contents">Contents:</label>
     	<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    </div>
    <input type="button" value="FileADD" class="btn btn-info" id="fileAdd">
      <div class="fileWrap">
      
       
   </div>
   	<input type="button" class="btn btn-primary" value="WRITE" id="btn">
    
  </form>
  
  <div id="f">
    <div class="input-group">
        <input id="files" type="file" class="form-control" name="files">
        <span class="input-group-addon del">DEL</span>
      </div>
  </div>
</div>

<script type="text/javascript" src="../resources/js/boardWrite.js">	

	</script>
	<script type="text/javascript">
	var count =0;	
	var f=$("#f").html();
	$("#fileAdd").click(function(){
		if(count<5){
		count++;
		$(".fileWrap").append(f);
		}else{
			alert("첨부파일은 최대5개까지 가능합니다");
		}
	});
	$(".fileWrap").on("click",".del",function(){
		$(this).parent().remove();
			count--;
		
			
		
		
	});	
	</script>
	
	
	
</body>
</html>