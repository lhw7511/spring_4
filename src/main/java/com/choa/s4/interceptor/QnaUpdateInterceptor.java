package com.choa.s4.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.qna.QnaDAO;
import com.choa.s4.member.MemberDTO;

@Component
public class QnaUpdateInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private QnaDAO qnaDAO;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long num=Long.parseLong(request.getParameter("num"));
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		boardDTO=qnaDAO.getOne(boardDTO);
		HttpSession session= request.getSession();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		String id = memberDTO.getId();
		boolean check=false;
		if(id.equals(boardDTO.getWriter())) {
			check=true;
		}else {
			request.setAttribute("msg", "작성자가아닙니다");
			request.setAttribute("path", "../");
			RequestDispatcher view =request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		//메서드 형식
		String method =request.getMethod();
		if(method.equals("POST")) {
			return ;
		}
		HttpSession session= request.getSession();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		String id = memberDTO.getId();
		BoardDTO boardDTO=(BoardDTO) mv.getModel().get("dto");
		String board =(String) mv.getModel().get("board");
		String writer = boardDTO.getWriter();
		if(!id.equals(writer)) {
			mv.addObject("board", board);
			mv.addObject("msg", "작성자가 아닙니다");
			mv.addObject("path", board+"List");
			mv.setViewName("common/result");
		}
	
	}
}
