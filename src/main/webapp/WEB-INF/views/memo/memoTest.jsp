<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			
			
			<c:forEach  items="${list}" var="dto" >
			<tr> 
			<td>${dto.num}</td>
			<td>${dto.writer}</td>
			<td>${dto.contents}</td>
    		<td>${dto.regdate}</td>
    		<td><button class="btn btn-danger del" id="${dto.num}">DEL</button></td>
    		</tr>
				</c:forEach>
	

	