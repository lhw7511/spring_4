package com.choa.s4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.choa.s4.member.MemberDTO;

/**
 * Servlet Filter implementation class NoticeFilter
 */
public class NoticeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NoticeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req=((HttpServletRequest)request);
		HttpSession session=req.getSession();
		MemberDTO memberDTO =(MemberDTO) session.getAttribute("member");
		String url = req.getRequestURL().toString();
		int i=url.lastIndexOf("/")+1;
		url=url.substring(i);
		if(memberDTO==null) {
			 if(url.equals("noticeList")||url.equals("noticeSelect")) {
					chain.doFilter(request, response);
			 }else {
				 ((HttpServletResponse)response).sendRedirect("../member/memberLogin");
			 }
		}else {
			if(memberDTO.getId().equals("admin")) {
				chain.doFilter(request, response);
			}else {
				if(url.equals("noticeList")||url.equals("noticeSelect")) {
					chain.doFilter(request, response);
				}else {
				 ((HttpServletResponse)response).sendRedirect("../");
			 }
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
