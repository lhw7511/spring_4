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
	.c1{
		cursor: pointer;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h1>${board} List</h1>
	
	 <table  class="table table-striped">
    	<tr> 
    			<td>NUM</td> <td>TITLE</td> <td>WRITER</td>  <td>REGDATE</td>  <td>HIT</td> 
    			
    	</tr>
    	
    		<c:forEach  items="${list}" var="dto" varStatus="vs">
    	 	
    		<tr>
    			<td>${dto.num}</td>
    			<td><a href="./${board}Select?num=${dto.num}">
    			<c:catch>
    			<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
    			</c:catch>
    			${dto.title}   			
    			</a></td>
    			<td>${dto.writer}</td>
    			<td>${dto.regDate}</td>
    			<td>${dto.hit}</td>
    		</tr>
 			</c:forEach>
    </table>
  
    	<c:if test="${pager.startNum gt 1}">
    		<span class="c1" title="${pager.startNum-1}">[이전]</span>
    	</c:if>
    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    				<span  class="c1" title="${i}">${i}</span>
    		</c:forEach>
    		
    		
    		<c:if test="${pager.nextCheck}">
    			<span class="c1" title="${pager.lastNum+1}">[다음]</span>
    		</c:if>
    		<div>
    		<c:if test="${not empty member and board ne 'notice' or not empty member and member.id eq 'admin' and board eq 'notice'}">
    		  <a href="./${board}Write" class="btn btn-default">WRITE</a>
    		 </c:if>
    		  </div>
    	</div>
   
   
  
  
    
<div class="container">
  <h3>${board} List</h3>
  <form action="./${board}List" id="frm">
  	<input type="hidden" name="curPage" id="curPage">
  	 <div class="input-group">
    		 <select id="kind" class="input-group-sm" name="kind">
   				 	<option value="tt" >Title</option>
    				<option value="wr">Writer</option>
   					 <option value="con">Contents</option>			
  			</select>
    		<input id="search" type="text" class="form-control" name="search" placeholder="검색">
    		</div>
    		<div class="input-group-btn">
      		<button class="btn btn-default" type="submit">
       		 <i class="glyphicon glyphicon-search"></i>
     		 </button>
 	 </div>
 	  
 	  </form>
</div>

<script type="text/javascript">
	
	
	var kind ='${pager.kind}';
	var search='${pager.search}';
	if(kind==''){
		$("#kind").val("tt");
	}else{
		$("#kind").val(kind);
	}
	
	$("#search").val(search);
		$(".c1").click(function(){
				var t=$(this).attr("title");
				
				$("#curPage").val(t);
				$("#frm").submit();
		});
	</script>
</body>
</html>