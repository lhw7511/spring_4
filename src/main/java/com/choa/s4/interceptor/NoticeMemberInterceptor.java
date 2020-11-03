package com.choa.s4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.s4.member.MemberDTO;
@Component
public class NoticeMemberInterceptor  extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("NoticememberInteceptor");
		HttpSession session = request.getSession();
		MemberDTO memberDTO=(MemberDTO) session.getAttribute("member");
		boolean check=false;
		if(memberDTO!=null&&memberDTO.getId().equals("admin")) {
			check=true;
		}else {
			request.setAttribute("msg", "권한이 없습니다");
			request.setAttribute("path", "../member/memberLogin");
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return check;
	}
}
