<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/bootStrap.jsp"></c:import>
<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style type="text/css">
#f {
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
		<h2>${board}Write form</h2>
		<form action="./${board}Write" method="post" id="frm"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter Title"
					name="title">
			</div>

			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text"
					class="form-control" id="writer" placeholder="Enter writer"
					name="writer" value="${member.id}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="10" id="contents"
					name="contents"></textarea>
			</div>
			<input type="button" value="FileADD" class="btn btn-info"
				id="fileAdd">
			<div class="fileWrap"></div>
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
	
	
	
	  $('#contents').summernote({
	      height:300,
	      callbacks:{
	    	  //이미지를 올렸을때
	         onImageUpload: function(files, editor) {
	            var formData = new FormData(); //가상의 form태그 작성
	            
	            
	                formData.append('file',files[0]); //파라미터 이름을 file로
	           
	        
	            
	            $.ajax({
	               type:"POST",
	               url:"./summernote",
	               data:formData,
	               enctype:"multipart/form-data",
	               cache:false,
	               contentType:false,
	               processData: false,
	               success: function(data) {
	                 	data=data.trim();
	                 	data="../resources/upload/${board}/"+data;
	                 	
	                 	$("#contents").summernote('editor.insertImage',data);
	               }
	            });
	         },//upload end
	         onMediaDelete: function(files){
	        	  var fileName =$(files[0]).attr("src");
	        	  var a=fileName.split("/");
	        	  fileName=a[a.length-1];
	        	 $.ajax({
	        		 type:"POST",
		             url:"./summernoteDelete",
		             data:{
		            	 file:fileName
		             },
		             success:function(data){
		            	 if(data){
		            		 alert("삭제 성공");
		            	 }else{
		            		 alert("삭제 실패");
		            	 }
		             }
	        	 });
	        	 
	         }
	  
	      }
	   });
		  
	</script>



</body>
</html>