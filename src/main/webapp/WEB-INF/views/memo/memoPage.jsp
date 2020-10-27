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
	<h1>Memo Page</h1>
		
	<div>
	
		  <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${member.id}" >
    </div>
    

    <div class="form-group">
      <label for="contents">Contents:</label>
     	<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    </div>
   
    	<div class="form-group">
    	<input type="button" class="btn btn-primary" value="WRITE" id="write">
    	</div>
	</div>

		<table class="table table-striped"  id="result">
			<tr> 
			<td>NUM</td> <td>WRITER</td> <td>contents</td>  <td>REGDATE</td> 
			</tr>
		</table>
	
	
	<button id="more" class="btn btn-primary">더보기</button>
	
	</div>
	
<script type="text/javascript">
    var curPage=1;
	getList();
 	function getList(){
 		 $.get("./memoList?curPage="+curPage,function(data){
 			  $("#result").append(data);
 		  }) ;
 	}
	 
  	$("#write").click(function(){
  		var writer =$("#writer").val();
  		var contents =$("#contents").val();
  	/*	
  		$.post("./memoWrite",{writer:writer,contents:contents},function(result){
  			alert(result);
  			$("#writer").val("");
  			$("#contents").val("");
  			getList();
  		});
  		*/
  		$.ajax({
  			 url:"./memoWrite",
  			 type:"POST",
  			 data:{writer:writer,contents:contents},
  			 success:function(result){
  				alert(result);
  	  			$("#writer").val("");
  	  			$("#contents").val("");
  	  			$("#result").html('');
				curPage=1;
  	  			getList();
  			 }
  			
  		})
  	});
  	
  	
  	
 	$("#result").on("click",".del",function(){
 					$.post("./memoDelete",{num:$(this).attr("id")},function(data){
 						alert(data);
 						$("#result").html('');
 						curPage=1;
 	 					getList();
 					});
 				
 			});
  	
  
 	$("#more").click(function(){
 		curPage++;
 		getList();
 	});
</script>
</body>
</html>